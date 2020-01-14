package me.zaneqin.weixin.service.impl;

import java.util.List;
import me.zaneqin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.zaneqin.weixin.mapper.WxFansMapper;
import me.zaneqin.weixin.domain.WxFans;
import me.zaneqin.weixin.service.IWxFansService;
import me.zaneqin.common.core.text.Convert;

/**
 * 微信粉丝Service业务层处理
 * 
 * @author ZaneQin
 * @date 2020-01-03
 */
@Service
public class WxFansServiceImpl implements IWxFansService 
{
    @Autowired
    private WxFansMapper wxFansMapper;

    /**
     * 查询微信粉丝
     * 
     * @param id 微信粉丝ID
     * @return 微信粉丝
     */
    @Override
    public WxFans selectWxFansById(Long id)
    {
        return wxFansMapper.selectWxFansById(id);
    }

    /**
     * 查询微信粉丝列表
     * 
     * @param wxFans 微信粉丝
     * @return 微信粉丝
     */
    @Override
    public List<WxFans> selectWxFansList(WxFans wxFans)
    {
        return wxFansMapper.selectWxFansList(wxFans);
    }

    /**
     * 新增微信粉丝
     * 
     * @param wxFans 微信粉丝
     * @return 结果
     */
    @Override
    public int insertWxFans(WxFans wxFans)
    {
        wxFans.setCreateTime(DateUtils.getNowDate());
        return wxFansMapper.insertWxFans(wxFans);
    }

    /**
     * 修改微信粉丝
     * 
     * @param wxFans 微信粉丝
     * @return 结果
     */
    @Override
    public int updateWxFans(WxFans wxFans)
    {
        wxFans.setUpdateTime(DateUtils.getNowDate());
        return wxFansMapper.updateWxFans(wxFans);
    }

    /**
     * 删除微信粉丝对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxFansByIds(String ids)
    {
        return wxFansMapper.deleteWxFansByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信粉丝信息
     * 
     * @param id 微信粉丝ID
     * @return 结果
     */
    @Override
    public int deleteWxFansById(Long id)
    {
        return wxFansMapper.deleteWxFansById(id);
    }

    /**
     * 根据openId获取微信粉丝
     * @param openId
     * @param wid
     * @return
     */
    @Override
    public WxFans selectWxFansByOpenId(String openId, String wid) {
        return wxFansMapper.selectWxFansByOpenId(openId, wid);
    }

}
