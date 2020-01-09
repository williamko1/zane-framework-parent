package me.zaneqin.weixin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.zaneqin.common.annotation.Log;
import me.zaneqin.common.config.Global;
import me.zaneqin.common.core.controller.BaseController;
import me.zaneqin.common.core.domain.AjaxResult;
import me.zaneqin.common.core.page.TableDataInfo;
import me.zaneqin.common.enums.BusinessType;
import me.zaneqin.common.utils.StringUtils;
import me.zaneqin.common.utils.poi.ExcelUtil;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.service.IWxFansService;
import me.zaneqin.weixin.service.SyncFansThread;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 微信粉丝Controller
 *
 * @author ZaneQin
 * @date 2020-01-03
 */
@Api("微信粉丝管理")
@Controller
@RequestMapping("/weixin/fans")
@Log4j2
public class WxFansController extends BaseController {


    @Autowired
    private WxMpService wxService;

    private String prefix = "weixin/fans";

    @Autowired
    private IWxFansService wxFansService;

    @RequiresPermissions("weixin:fans:view")
    @GetMapping()
    public String fans() {
        return prefix + "/fans";
    }

    /**
     * 查询微信粉丝列表
     */
    @ApiOperation("查询微信粉丝列表")
    @ApiImplicitParam(name = "wxFans", value = "查询微信粉丝信息", dataType = "WxFans")
    @RequiresPermissions("weixin:fans:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxFans wxFans) {
        startPage();
        List<WxFans> list = wxFansService.selectWxFansList(wxFans);
        return getDataTable(list);
    }

    /**
     * 导出微信粉丝列表
     */
    @ApiOperation("导出微信粉丝列表")
    @ApiImplicitParam(name = "wxFans", value = "查询微信粉丝信息", dataType = "WxFans")
    @RequiresPermissions("weixin:fans:export")
    @Log(title = "微信粉丝", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxFans wxFans) {
        List<WxFans> list = wxFansService.selectWxFansList(wxFans);
        ExcelUtil<WxFans> util = new ExcelUtil<WxFans>(WxFans.class);
        return util.exportExcel(list, "fans");
    }

    /**
     * 新增微信粉丝
     */
    @ApiOperation("新增微信粉丝")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存微信粉丝
     */
    @ApiOperation("新增保存微信粉丝")
    @ApiImplicitParam(name = "wxFans", value = "保存微信粉丝信息", dataType = "WxFans")
    @RequiresPermissions("weixin:fans:add")
    @Log(title = "微信粉丝", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxFans wxFans) {
        return toAjax(wxFansService.insertWxFans(wxFans));
    }

    /**
     * 修改微信粉丝
     */
    @ApiOperation("修改微信粉丝")
    @ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "path")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxFans wxFans = wxFansService.selectWxFansById(id);
        mmap.put("wxFans", wxFans);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信粉丝
     */
    @ApiOperation("修改保存微信粉丝")
    @ApiImplicitParam(name = "wxFans", value = "修改微信粉丝信息", dataType = "WxFans")
    @RequiresPermissions("weixin:fans:edit")
    @Log(title = "微信粉丝", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxFans wxFans) {
        return toAjax(wxFansService.updateWxFans(wxFans));
    }

    /**
     * 删除微信粉丝
     */
    @ApiOperation("删除微信粉丝")
    @ApiImplicitParam(name = "ids", value = "id列表','分隔", dataType = "String")
    @RequiresPermissions("weixin:fans:remove")
    @Log(title = "微信粉丝", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wxFansService.deleteWxFansByIds(ids));
    }


    /**
     * 粉丝同步
     *
     * @return
     */
    @ApiOperation("粉丝同步")
    @PostMapping("/syncFans")
    @ResponseBody
    public AjaxResult syncFans() throws WxErrorException {
        String appId = wxService.getWxMpConfigStorage().getAppId();
        String message;
        WxMpUserList wxUserList = wxService.getUserService().userList(null);
        message = "同步粉丝任务已启动,请稍候刷新。关注用户总数：" + wxUserList.getTotal();
        Thread synThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //多线程处理数据
                ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,1, TimeUnit.SECONDS,new LinkedBlockingQueue());
                List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(2000);
                try {
                    String nextOpenId;
                    int count = 0;

                    do {
                        // 获取微信关注列表，1000人一个线程做同步
                        WxMpUserList wxUserList = wxService.getUserService().userList(null);
                        if (wxUserList.getCount() > 0) {
                            futures.add(executor.submit(new SyncFansThread(appId, wxUserList.getOpenids())));
                        }
                        // 更新下个周期的openId开始
                        nextOpenId = wxUserList.getNextOpenid();
                        count = wxUserList.getCount();
                    } while (StringUtils.isNotEmpty(nextOpenId) && count == 10000);
                    executor.shutdown();
                    // 线程池结束判断
                    while (true) {
                        if (executor.isTerminated()) {
                            break;
                        }
                        Thread.sleep(200);
                    }
                } catch (WxErrorException e) {
                    log.error("微信同步失败");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        synThread.start();
        return AjaxResult.success(message);
    }
}
