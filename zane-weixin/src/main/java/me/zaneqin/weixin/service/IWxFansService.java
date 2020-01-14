package me.zaneqin.weixin.service;

import me.zaneqin.weixin.domain.WxFans;
import java.util.List;

/**
 * 微信粉丝Service接口
 * 
 * @author ZaneQin
 * @date 2020-01-03
 */
public interface IWxFansService 
{
    /**
     * 查询微信粉丝
     * 
     * @param id 微信粉丝ID
     * @return 微信粉丝
     */
    public WxFans selectWxFansById(Long id);

    /**
     * 查询微信粉丝列表
     * 
     * @param wxFans 微信粉丝
     * @return 微信粉丝集合
     */
    public List<WxFans> selectWxFansList(WxFans wxFans);

    /**
     * 新增微信粉丝
     * 
     * @param wxFans 微信粉丝
     * @return 结果
     */
    public int insertWxFans(WxFans wxFans);

    /**
     * 修改微信粉丝
     * 
     * @param wxFans 微信粉丝
     * @return 结果
     */
    public int updateWxFans(WxFans wxFans);

    /**
     * 批量删除微信粉丝
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxFansByIds(String ids);

    /**
     * 删除微信粉丝信息
     * 
     * @param id 微信粉丝ID
     * @return 结果
     */
    public int deleteWxFansById(Long id);

    /**
     * 根据openId获取微信粉丝
     * @param openId
     * @param wid
     * @return
     */
    WxFans selectWxFansByOpenId(String openId, String wid);

}
