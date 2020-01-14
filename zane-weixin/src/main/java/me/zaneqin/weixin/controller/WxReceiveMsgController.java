package me.zaneqin.controller.weixin;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import me.zaneqin.weixin.domain.WxReceiveMsg;
import me.zaneqin.weixin.service.IWxReceiveMsgService;
import me.zaneqin.common.core.controller.BaseController;
import me.zaneqin.common.core.domain.AjaxResult;
import me.zaneqin.common.utils.poi.ExcelUtil;
import me.zaneqin.common.core.page.TableDataInfo;

/**
 * 历史消息Controller
 * 
 * @author ZaneQin
 * @date 2020-01-14
 */
@Api("历史消息管理")
@Controller
@RequestMapping("/weixin/msg")
public class WxReceiveMsgController extends BaseController
{
    private String prefix = "weixin/msg";

    @Autowired
    private IWxReceiveMsgService wxReceiveMsgService;

    @RequiresPermissions("weixin:msg:view")
    @GetMapping()
    public String msg()
    {
        return prefix + "/msg";
    }

    /**
     * 查询历史消息列表
     */
    @ApiOperation("查询历史消息列表")
    @ApiImplicitParam(name = "wxReceiveMsg", value = "查询历史消息信息", dataType = "WxReceiveMsg")
    @RequiresPermissions("weixin:msg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxReceiveMsg wxReceiveMsg)
    {
        startPage();
        List<WxReceiveMsg> list = wxReceiveMsgService.selectWxReceiveMsgList(wxReceiveMsg);
        return getDataTable(list);
    }

    /**
     * 导出历史消息列表
     */
    @ApiOperation("导出历史消息列表")
    @ApiImplicitParam(name = "wxReceiveMsg", value = "查询历史消息信息", dataType = "WxReceiveMsg")
    @RequiresPermissions("weixin:msg:export")
    @Log(title = "历史消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxReceiveMsg wxReceiveMsg)
    {
        List<WxReceiveMsg> list = wxReceiveMsgService.selectWxReceiveMsgList(wxReceiveMsg);
        ExcelUtil<WxReceiveMsg> util = new ExcelUtil<WxReceiveMsg>(WxReceiveMsg.class);
        return util.exportExcel(list, "msg");
    }

    /**
     * 新增历史消息
     */
    @ApiOperation("新增历史消息")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存历史消息
     */
    @ApiOperation("新增保存历史消息")
    @ApiImplicitParam(name = "wxReceiveMsg", value = "保存历史消息信息", dataType = "WxReceiveMsg")
    @RequiresPermissions("weixin:msg:add")
    @Log(title = "历史消息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxReceiveMsg wxReceiveMsg)
    {
        return toAjax(wxReceiveMsgService.insertWxReceiveMsg(wxReceiveMsg));
    }

    /**
     * 修改历史消息
     */
    @ApiOperation("修改历史消息")
    @ApiImplicitParam(name = "msgId", value = "msgId", dataType = "Long", paramType = "path")
    @GetMapping("/edit/{msgId}")
    public String edit(@PathVariable("msgId") Long msgId, ModelMap mmap)
    {
        WxReceiveMsg wxReceiveMsg = wxReceiveMsgService.selectWxReceiveMsgById(msgId);
        mmap.put("wxReceiveMsg", wxReceiveMsg);
        return prefix + "/edit";
    }

    /**
     * 修改保存历史消息
     */
    @ApiOperation("修改保存历史消息")
    @ApiImplicitParam(name = "wxReceiveMsg", value = "修改历史消息信息", dataType = "WxReceiveMsg")
    @RequiresPermissions("weixin:msg:edit")
    @Log(title = "历史消息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxReceiveMsg wxReceiveMsg)
    {
        return toAjax(wxReceiveMsgService.updateWxReceiveMsg(wxReceiveMsg));
    }

    /**
     * 删除历史消息
     */
    @ApiOperation("删除历史消息")
    @ApiImplicitParam(name = "ids", value = "id列表','分隔", dataType = "String")
    @RequiresPermissions("weixin:msg:remove")
    @Log(title = "历史消息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxReceiveMsgService.deleteWxReceiveMsgByIds(ids));
    }
}
