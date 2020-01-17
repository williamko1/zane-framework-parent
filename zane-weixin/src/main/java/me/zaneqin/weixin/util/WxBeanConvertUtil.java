package me.zaneqin.weixin.util;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.domain.WxReceiveMsg;

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
    public static WxFans convert(WxMpUser wxMpUser) {
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

    // 微信消息
    public static WxReceiveMsg convert(WxMpXmlMessage wxMpXmlMessage) {
        String msgType = wxMpXmlMessage.getMsgType();
        WxReceiveMsg msg = new WxReceiveMsg();
        msg.setMsgId(String.valueOf(wxMpXmlMessage.getMsgId()));
        msg.setFromUserName(wxMpXmlMessage.getFromUser());
        msg.setToUserName(wxMpXmlMessage.getToUser());
        msg.setWid(wxMpXmlMessage.getToUser());
        msg.setMsgType(msgType);
        msg.setCreateTime(new Date(wxMpXmlMessage.getCreateTime() * 1000));
        if (WxConsts.XmlMsgType.TEXT.equals(msgType)) {
            msg.setContent(wxMpXmlMessage.getContent());
        }
        if (WxConsts.XmlMsgType.VOICE.equals(msgType)) {
            msg.setMediaId(wxMpXmlMessage.getMediaId());
            msg.setFormat(wxMpXmlMessage.getFormat());
        }
        if (WxConsts.XmlMsgType.IMAGE.equals(msgType)) {
            msg.setMediaId(wxMpXmlMessage.getMediaId());
            msg.setPicUrl(wxMpXmlMessage.getPicUrl());
        }
        if (WxConsts.XmlMsgType.VIDEO.equals(msgType) || WxConsts.XmlMsgType.SHORTVIDEO.equals(msgType)) {
            msg.setMediaId(wxMpXmlMessage.getMediaId());
            msg.setThumbMediaId(wxMpXmlMessage.getThumbMediaId());
        }
        if (WxConsts.XmlMsgType.LINK.equals(msgType)) {
            msg.setTitle(wxMpXmlMessage.getTitle());
            msg.setDescription(wxMpXmlMessage.getDescription());
            msg.setUrl(wxMpXmlMessage.getUrl());
        }
        return msg;
    }

}
