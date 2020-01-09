package me.zaneqin.weixin.service;

import lombok.extern.log4j.Log4j2;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.zaneqin.common.utils.DateUtils;
import me.zaneqin.common.utils.spring.SpringUtils;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.mapper.WxFansMapper;
import me.zaneqin.weixin.util.WxBeanConvertUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * desc : 粉丝同步线程
 * 一次1000个等待同步openId列表
 * 请求10次详情，一次100个详情
 *
 * @author : Zane Qin
 * creatTime : 15:10 2020/1/7
 * modifier:
 * modifyTime:
 */
@Log4j2
public class SyncFansThread implements Callable<Boolean> {

    private WxFansMapper fansDao = SpringUtils.getBean(WxFansMapper.class);
    private WxMpService wxService = SpringUtils.getBean(WxMpService.class);

    //公众号ID
    private String wid;
    //粉丝列表
    private List<String> openIdArr;

    public SyncFansThread(String wid, List<String> openIdArr) {
        this.wid = wid;
        this.openIdArr = openIdArr;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            log.info("--------SyncFansThread--------公众号【" + this.wid + "】-获取新粉丝任务开始");
            log.info("--------SyncFansThread--------公众号【" + this.wid + "】-获取新粉丝任务从微信取得粉丝数：" + openIdArr.size());
            for (int i = 1; i <= openIdArr.size() / 100 + 1; i++) {
                int endIndex = i * 100;
                if (endIndex >= openIdArr.size()) {
                    endIndex = openIdArr.size();
                }
                List<WxMpUser> wxMpUsers = wxService.getUserService().userInfoList(openIdArr.subList(0, endIndex));
                for (WxMpUser wxMpUser : wxMpUsers) {
                    String openId = wxMpUser.getOpenId();
                    //1.判断当前粉丝在表中是否存在
                    WxFans fan = fansDao.selectWxFansByOpenId(openId, wid);
                    //2.不存在，添加
                    WxFans newFan = WxBeanConvertUtil.wxFansConvert(wxMpUser);
                    newFan.setWid(wid);
                    if (fan == null) {
                        fansDao.insertWxFans(newFan);
                    } else {
                        // 存在修改
                        newFan.setId(fan.getId());
                        fansDao.updateWxFans(newFan);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("--------SyncFansThread--------公众号【" + this.wid + "】-获取新粉丝任务失败：" + e.toString());
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String d = "1970-01-19 12:38:07";
        System.out.println(new Date(DateUtils.parseDate(d).getTime()*1000));
    }
}
