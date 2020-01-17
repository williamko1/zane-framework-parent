package me.zaneqin.weixin.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.zaneqin.common.annotation.Excel;
import me.zaneqin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 历史消息对象 wx_receive_msg
 * 
 * @author ZaneQin
 * @date 2020-01-14
 */
@ApiModel("历史消息")
public class WxReceiveMsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息id */

    @ApiModelProperty("消息id")
    private String msgId;

    /** 开发者微信号 */

    @ApiModelProperty("开发者微信号")
    private String toUserName;

    /** 发送方帐号 */

    @Excel(name = "发送方帐号")
    @ApiModelProperty("发送方帐号")
    private String fromUserName;

    /** 消息类型 */

    @Excel(name = "消息类型")
    @ApiModelProperty("消息类型")
    private String msgType;

    /** 微信appid号 */

    @Excel(name = "微信appid号")
    @ApiModelProperty("微信appid号")
    private String wid;

    /** 文本消息内容 */

    @Excel(name = "文本消息内容")
    @ApiModelProperty("文本消息内容")
    private String content;

    /** 媒体id */

    @ApiModelProperty("媒体id")
    private String mediaId;

    /** 图片url */

    @ApiModelProperty("图片url")
    private String picUrl;

    /** 语音格式 */

    @ApiModelProperty("语音格式")
    private String format;

    /** 语音识别结果 */

    @ApiModelProperty("语音识别结果")
    private String recognition;

    /** 视频消息缩略图id */

    @ApiModelProperty("视频消息缩略图id")
    private String thumbMediaId;

    /** 消息标题 */

    @ApiModelProperty("消息标题")
    private String title;

    /** 消息描述 */

    @ApiModelProperty("消息描述")
    private String description;

    /** 消息链接 */

    @ApiModelProperty("消息链接")
    private String url;

    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }

    public String getMsgId()
    {
        return msgId;
    }
    public void setToUserName(String toUserName) 
    {
        this.toUserName = toUserName;
    }

    public String getToUserName() 
    {
        return toUserName;
    }
    public void setFromUserName(String fromUserName) 
    {
        this.fromUserName = fromUserName;
    }

    public String getFromUserName() 
    {
        return fromUserName;
    }
    public void setMsgType(String msgType) 
    {
        this.msgType = msgType;
    }

    public String getMsgType() 
    {
        return msgType;
    }
    public void setWid(String wid) 
    {
        this.wid = wid;
    }

    public String getWid() 
    {
        return wid;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setMediaId(String mediaId) 
    {
        this.mediaId = mediaId;
    }

    public String getMediaId() 
    {
        return mediaId;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setFormat(String format) 
    {
        this.format = format;
    }

    public String getFormat() 
    {
        return format;
    }
    public void setRecognition(String recognition) 
    {
        this.recognition = recognition;
    }

    public String getRecognition() 
    {
        return recognition;
    }
    public void setThumbMediaId(String thumbMediaId) 
    {
        this.thumbMediaId = thumbMediaId;
    }

    public String getThumbMediaId() 
    {
        return thumbMediaId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("msgId", getMsgId())
            .append("toUserName", getToUserName())
            .append("fromUserName", getFromUserName())
            .append("msgType", getMsgType())
            .append("createTime", getCreateTime())
            .append("wid", getWid())
            .append("content", getContent())
            .append("mediaId", getMediaId())
            .append("picUrl", getPicUrl())
            .append("format", getFormat())
            .append("recognition", getRecognition())
            .append("thumbMediaId", getThumbMediaId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("url", getUrl())
            .toString();
    }
}
