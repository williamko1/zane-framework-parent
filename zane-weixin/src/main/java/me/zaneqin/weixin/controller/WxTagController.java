package me.zaneqin.controller.weixin;

import java.util.Date;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.service.IWxFansService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import me.zaneqin.common.annotation.Log;
import me.zaneqin.common.enums.BusinessType;
import me.zaneqin.weixin.domain.WxTag;
import me.zaneqin.weixin.service.IWxTagService;
import me.zaneqin.common.core.controller.BaseController;
import me.zaneqin.common.core.domain.AjaxResult;
import me.zaneqin.common.utils.poi.ExcelUtil;
import me.zaneqin.common.core.page.TableDataInfo;

/**
 * 微信标签Controller
 * 
 * @author ZaneQin
 * @date 2020-01-10
 */
@Api("微信标签管理")
@Controller
@RequestMapping("/weixin/tag")
public class WxTagController extends BaseController
{
    private String prefix = "weixin/tag";

    @Autowired
    private WxMpService wxService;

    @Autowired
    private IWxTagService wxTagService;

    @Autowired
    private IWxFansService wxFansService;

    @RequiresPermissions("weixin:tag:view")
    @GetMapping()
    public String tag()
    {
        return prefix + "/tag";
    }

    /**
     * 查询微信标签列表
     */
    @ApiOperation("查询微信标签列表")
    @ApiImplicitParam(name = "wxTag", value = "查询微信标签信息", dataType = "WxTag")
    @RequiresPermissions("weixin:tag:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxTag wxTag)
    {
        startPage();
        List<WxTag> list = wxTagService.selectWxTagList(wxTag);
        return getDataTable(list);
    }

    /**
     * 导出微信标签列表
     */
    @ApiOperation("导出微信标签列表")
    @ApiImplicitParam(name = "wxTag", value = "查询微信标签信息", dataType = "WxTag")
    @RequiresPermissions("weixin:tag:export")
    @Log(title = "微信标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxTag wxTag)
    {
        List<WxTag> list = wxTagService.selectWxTagList(wxTag);
        ExcelUtil<WxTag> util = new ExcelUtil<WxTag>(WxTag.class);
        return util.exportExcel(list, "tag");
    }

    /**
     * 新增微信标签
     */
    @ApiOperation("新增微信标签")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信标签
     */
    @ApiOperation("新增保存微信标签")
    @ApiImplicitParam(name = "wxTag", value = "保存微信标签信息", dataType = "WxTag")
    @RequiresPermissions("weixin:tag:add")
    @Log(title = "微信标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxTag wxTag) throws WxErrorException {
        WxUserTag wxUserTag = wxService.getUserTagService().tagCreate(wxTag.getName());
        wxTag.setId(wxUserTag.getId());
        wxTag.setWid(wxService.getWxMpConfigStorage().getAppId());
        return toAjax(wxTagService.insertWxTag(wxTag));
    }

    /**
     * 修改微信标签
     */
    @ApiOperation("修改微信标签")
    @ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "path")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxTag wxTag = wxTagService.selectWxTagById(id);
        mmap.put("wxTag", wxTag);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信标签
     */
    @ApiOperation("修改保存微信标签")
    @ApiImplicitParam(name = "wxTag", value = "修改微信标签信息", dataType = "WxTag")
    @RequiresPermissions("weixin:tag:edit")
    @Log(title = "微信标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxTag wxTag) throws WxErrorException {
        wxService.getUserTagService().tagUpdate(wxTag.getId(), wxTag.getName());
        return toAjax(wxTagService.updateWxTag(wxTag));
    }

    /**
     * 删除微信标签
     */
    @ApiOperation("删除微信标签")
    @ApiImplicitParam(name = "ids", value = "id列表','分隔", dataType = "String")
    @RequiresPermissions("weixin:tag:remove")
    @Log(title = "微信标签", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) throws WxErrorException {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            wxService.getUserTagService().tagDelete(Long.valueOf(id));
        }
        return toAjax(wxTagService.deleteWxTagByIds(ids));
    }


    @ApiOperation("同步微信标签")
    @PostMapping("/sync")
    @ResponseBody
    public AjaxResult sync() throws WxErrorException {
        String appid = wxService.getWxMpConfigStorage().getAppId();
        List<WxUserTag> wxUserTags = wxService.getUserTagService().tagGet();
        // 删除所有tag
        wxTagService.deleteAllWxTagByWid(appid);
        // 同步创建tag
        for (WxUserTag tag : wxUserTags) {
            WxTag newTag = new WxTag();
            newTag.setId(tag.getId());
            newTag.setName(tag.getName());
            newTag.setWid(appid);
            newTag.setCreateTime(new Date());
            newTag.setUpdateTime(new Date());
            wxTagService.insertWxTag(newTag);
        }
        return AjaxResult.success("标签同步成功");
    }

    /**
     * 打标签
     */
    @RequiresPermissions("system:dict:list")
    @GetMapping("/tag/{tagId}")
    public String detail(@PathVariable("tagId") Long tagId, ModelMap mmap)
    {
        WxFans query = new WxFans();
        query.setWid(wxService.getWxMpConfigStorage().getAppId());
        query.setTagList(String.valueOf(tagId));
        mmap.put("tag", wxTagService.selectWxTagById(tagId));
        mmap.put("fanList", wxFansService.selectWxFansList(query));
        return "weixin/fans/fans";
    }
}
