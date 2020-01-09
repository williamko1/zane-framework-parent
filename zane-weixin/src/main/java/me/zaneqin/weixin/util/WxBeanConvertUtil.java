package me.zaneqin.weixin.util;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.zaneqin.weixin.domain.WxFans;

import java.util.Arrays;
import java.util.Date;

/**
 * desc : 微信实体转换类
 *
 * @author : Zane Qin
 * creatTime : 16:31 2020/1/7
 * modifier:
 * modifyTime:
 */
public class WxBeanConvertUtil {

    // 微信粉丝
    public static WxFans wxFansConvert(WxMpUser wxMpUser) {
        WxFans newFan = new WxFans();
        newFan.setOpenid(wxMpUser.getOpenId());
        if (wxMpUser.getSubscribe()) {
            newFan.setSubscribe("1");
            newFan.setCity(wxMpUser.getCity());
            newFan.setCountry(wxMpUser.getCountry());
            newFan.setHeadImgUrl(wxMpUser.getHeadImgUrl());
            newFan.setNickname(wxMpUser.getNickname());
            newFan.setNicknameTxt(wxMpUser.getNickname());
            newFan.setOpenid(wxMpUser.getOpenId());
            newFan.setProvince(wxMpUser.getProvince());
            newFan.setSex(String.valueOf(wxMpUser.getSex()));
            newFan.setSubscribe(wxMpUser.getSubscribe() ? "1" : "0");
            newFan.setSubscribeTime(new Date(wxMpUser.getSubscribeTime() * 1000));
            newFan.setSubscribeScene(wxMpUser.getSubscribeScene());
            newFan.setQrScene(wxMpUser.getQrScene());
            newFan.setQrSceneStr(wxMpUser.getQrSceneStr());
            newFan.setGroupId(String.valueOf(wxMpUser.getGroupId()));
            newFan.setLanguage(wxMpUser.getLanguage());
            newFan.setNoteName(wxMpUser.getRemark());
            newFan.setTagList(Arrays.toString(wxMpUser.getTagIds()));
        } else {
            newFan.setSubscribe("0");
        }
        return newFan;
    }

}
