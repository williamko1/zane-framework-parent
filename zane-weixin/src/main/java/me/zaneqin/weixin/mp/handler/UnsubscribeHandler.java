package me.zaneqin.weixin.mp.handler;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.service.IWxFansService;
import me.zaneqin.weixin.util.WxBeanConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : Zane Qin
 * createTime : 13:45 2020/1/2
 * modifier :
 * modifyTime :
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

    @Autowired
    IWxFansService wxFansService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);
        // 更新本地数据库为取消关注状态
        String appId = wxMpService.getWxMpConfigStorage().getAppId();
        WxFans oldFan = wxFansService.selectWxFansByOpenId(openId, appId);
        if (oldFan != null) {
            oldFan.setSubscribe("0");
            wxFansService.updateWxFans(oldFan);
        }
        return null;
    }

}
