package me.zaneqin.weixin.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.zaneqin.common.annotation.Excel;
import me.zaneqin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 微信粉丝对象 wx_fans
 * 
 * @author ZaneQin
 * @date 2020-01-03
 */
@ApiModel("微信粉丝")
public class WxFans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */

    @ApiModelProperty("序号")
    private Long id;

    /** openid */

    @Excel(name = "openid")
    @ApiModelProperty("openid")
    private String openid;

    /** 昵称 */

    @Excel(name = "昵称")
    @ApiModelProperty("昵称")
    private String nickname;

    /** 过滤后昵称 */

    @Excel(name = "过滤后昵称")
    @ApiModelProperty("过滤后昵称")
    private String nicknameTxt;

    /** 备注名称 */

    @Excel(name = "备注名称")
    @ApiModelProperty("备注名称")
    private String noteName;

    /** 用户头像 */

    @Excel(name = "用户头像")
    @ApiModelProperty("用户头像")
    private String headImgUrl;

    /** 性别： */

    @Excel(name = "性别：")
    @ApiModelProperty("性别：")
    private String sex;

    /** 是否关注: */

    @Excel(name = "是否关注:")
    @ApiModelProperty("是否关注:")
    private String subscribe;

    /** 关注时间 */

    @Excel(name = "关注时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("关注时间")
    private Date subscribeTime;

    /** 用户关注渠道来源 */

    @Excel(name = "用户关注渠道来源")
    @ApiModelProperty("用户关注渠道来源")
    private String subscribeScene;

    /** 手机号 */

    @Excel(name = "手机号")
    @ApiModelProperty("手机号")
    private String mobile;

    /** 绑定状态： */

    @Excel(name = "绑定状态：")
    @ApiModelProperty("绑定状态：")
    private String bindStatus;

    /** 绑定时间 */

    @Excel(name = "绑定时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("绑定时间")
    private Date bindTime;

    /** 标签id */

    @Excel(name = "标签id")
    @ApiModelProperty("标签id")
    private String tagList;

    /** 省份 */

    @Excel(name = "省份")
    @ApiModelProperty("省份")
    private String province;

    /** 城市 */

    @Excel(name = "城市")
    @ApiModelProperty("城市")
    private String city;

    /** 地区 */

    @Excel(name = "地区")
    @ApiModelProperty("地区")
    private String country;

    /** 二维码扫码场景 */

    @Excel(name = "二维码扫码场景")
    @ApiModelProperty("二维码扫码场景")
    private String qrScene;

    /** 二维码扫码常见描述 */

    @Excel(name = "二维码扫码常见描述")
    @ApiModelProperty("二维码扫码常见描述")
    private String qrSceneStr;

    /** 用户所在分组id */

    @Excel(name = "用户所在分组id")
    @ApiModelProperty("用户所在分组id")
    private String groupId;

    /** 用户的语言，简体中文为zh_CN */

    @Excel(name = "用户的语言，简体中文为zh_CN")
    @ApiModelProperty("用户的语言，简体中文为zh_CN")
    private String language;

    /** unionId */

    @Excel(name = "unionId")
    @ApiModelProperty("unionId")
    private String unionId;

    /** 公众号原始id */

    @Excel(name = "公众号原始id")
    @ApiModelProperty("公众号原始id")
    private String wid;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setNicknameTxt(String nicknameTxt) 
    {
        this.nicknameTxt = nicknameTxt;
    }

    public String getNicknameTxt() 
    {
        return nicknameTxt;
    }
    public void setNoteName(String noteName) 
    {
        this.noteName = noteName;
    }

    public String getNoteName() 
    {
        return noteName;
    }
    public void setHeadImgUrl(String headImgUrl) 
    {
        this.headImgUrl = headImgUrl;
    }

    public String getHeadImgUrl() 
    {
        return headImgUrl;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setSubscribe(String subscribe) 
    {
        this.subscribe = subscribe;
    }

    public String getSubscribe() 
    {
        return subscribe;
    }
    public void setSubscribeTime(Date subscribeTime) 
    {
        this.subscribeTime = subscribeTime;
    }

    public Date getSubscribeTime() 
    {
        return subscribeTime;
    }
    public void setSubscribeScene(String subscribeScene) 
    {
        this.subscribeScene = subscribeScene;
    }

    public String getSubscribeScene() 
    {
        return subscribeScene;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setBindStatus(String bindStatus) 
    {
        this.bindStatus = bindStatus;
    }

    public String getBindStatus() 
    {
        return bindStatus;
    }
    public void setBindTime(Date bindTime) 
    {
        this.bindTime = bindTime;
    }

    public Date getBindTime() 
    {
        return bindTime;
    }
    public void setTagList(String tagList) 
    {
        this.tagList = tagList;
    }

    public String getTagList() 
    {
        return tagList;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setQrScene(String qrScene) 
    {
        this.qrScene = qrScene;
    }

    public String getQrScene() 
    {
        return qrScene;
    }
    public void setQrSceneStr(String qrSceneStr) 
    {
        this.qrSceneStr = qrSceneStr;
    }

    public String getQrSceneStr() 
    {
        return qrSceneStr;
    }
    public void setGroupId(String groupId) 
    {
        this.groupId = groupId;
    }

    public String getGroupId() 
    {
        return groupId;
    }
    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public String getLanguage() 
    {
        return language;
    }
    public void setUnionId(String unionId) 
    {
        this.unionId = unionId;
    }

    public String getUnionId() 
    {
        return unionId;
    }
    public void setWid(String wid) 
    {
        this.wid = wid;
    }

    public String getWid() 
    {
        return wid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openid", getOpenid())
            .append("nickname", getNickname())
            .append("nicknameTxt", getNicknameTxt())
            .append("noteName", getNoteName())
            .append("headImgUrl", getHeadImgUrl())
            .append("sex", getSex())
            .append("subscribe", getSubscribe())
            .append("subscribeTime", getSubscribeTime())
            .append("subscribeScene", getSubscribeScene())
            .append("mobile", getMobile())
            .append("bindStatus", getBindStatus())
            .append("bindTime", getBindTime())
            .append("tagList", getTagList())
            .append("province", getProvince())
            .append("city", getCity())
            .append("country", getCountry())
            .append("qrScene", getQrScene())
            .append("qrSceneStr", getQrSceneStr())
            .append("groupId", getGroupId())
            .append("language", getLanguage())
            .append("unionId", getUnionId())
            .append("wid", getWid())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
