package me.zaneqin.weixin.mapper;

import me.zaneqin.weixin.domain.WxTag;
import java.util.List;

/**
 * 微信标签Mapper接口
 * 
 * @author ZaneQin
 * @date 2020-01-10
 */
public interface WxTagMapper 
{
    /**
     * 查询微信标签
     * 
     * @param id 微信标签ID
     * @return 微信标签
     */
    public WxTag selectWxTagById(Long id);

    /**
     * 查询微信标签列表
     * 
     * @param wxTag 微信标签
     * @return 微信标签集合
     */
    public List<WxTag> selectWxTagList(WxTag wxTag);

    /**
     * 新增微信标签
     * 
     * @param wxTag 微信标签
     * @return 结果
     */
    public int insertWxTag(WxTag wxTag);

    /**
     * 修改微信标签
     * 
     * @param wxTag 微信标签
     * @return 结果
     */
    public int updateWxTag(WxTag wxTag);

    /**
     * 删除微信标签
     * 
     * @param id 微信标签ID
     * @return 结果
     */
    public int deleteWxTagById(Long id);

    /**
     * 批量删除微信标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxTagByIds(String[] ids);

    /**
     * 删除所有微信标签w
     * @param wid 所属微信号ID
     * @return 结果
     */
    int deleteAllWxTagByWid(String wid);
}
