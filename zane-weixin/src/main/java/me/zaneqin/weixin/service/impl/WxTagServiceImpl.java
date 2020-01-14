package me.zaneqin.weixin.service.impl;

import java.util.List;
import me.zaneqin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.zaneqin.weixin.mapper.WxTagMapper;
import me.zaneqin.weixin.domain.WxTag;
import me.zaneqin.weixin.service.IWxTagService;
import me.zaneqin.common.core.text.Convert;

/**
 * 微信标签Service业务层处理
 * 
 * @author ZaneQin
 * @date 2020-01-10
 */
@Service
public class WxTagServiceImpl implements IWxTagService 
{
    @Autowired
    private WxTagMapper wxTagMapper;

    /**
     * 查询微信标签
     * 
     * @param id 微信标签ID
     * @return 微信标签
     */
    @Override
    public WxTag selectWxTagById(Long id)
    {
        return wxTagMapper.selectWxTagById(id);
    }

    /**
     * 查询微信标签列表
     * 
     * @param wxTag 微信标签
     * @return 微信标签
     */
    @Override
    public List<WxTag> selectWxTagList(WxTag wxTag)
    {
        return wxTagMapper.selectWxTagList(wxTag);
    }

    /**
     * 新增微信标签
     * 
     * @param wxTag 微信标签
     * @return 结果
     */
    @Override
    public int insertWxTag(WxTag wxTag)
    {
        wxTag.setCreateTime(DateUtils.getNowDate());
        return wxTagMapper.insertWxTag(wxTag);
    }

    /**
     * 修改微信标签
     * 
     * @param wxTag 微信标签
     * @return 结果
     */
    @Override
    public int updateWxTag(WxTag wxTag)
    {
        wxTag.setUpdateTime(DateUtils.getNowDate());
        return wxTagMapper.updateWxTag(wxTag);
    }

    /**
     * 删除微信标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxTagByIds(String ids)
    {
        return wxTagMapper.deleteWxTagByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信标签信息
     * 
     * @param id 微信标签ID
     * @return 结果
     */
    @Override
    public int deleteWxTagById(Long id)
    {
        return wxTagMapper.deleteWxTagById(id);
    }

    /**
     * 删除所有微信标签
     * @param wid 所属微信号ID
     * @return 结果
     */
    @Override
    public int deleteAllWxTagByWid(String wid) {
        return wxTagMapper.deleteAllWxTagByWid(wid);
    }
}
