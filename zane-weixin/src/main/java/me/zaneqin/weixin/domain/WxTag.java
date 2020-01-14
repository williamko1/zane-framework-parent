package me.zaneqin.weixin.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.zaneqin.common.annotation.Excel;
import me.zaneqin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 微信标签对象 wx_tag
 * 
 * @author ZaneQin
 * @date 2020-01-10
 */
@ApiModel("微信标签")
public class WxTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */

    @ApiModelProperty("主键")
    private Long id;

    /** 标签名称 */

    @Excel(name = "标签名称")
    @ApiModelProperty("标签名称")
    private String name;

    /** 微信号 */

    @Excel(name = "微信号")
    @ApiModelProperty("微信号")
    private String wid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("name", getName())
            .append("wid", getWid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
