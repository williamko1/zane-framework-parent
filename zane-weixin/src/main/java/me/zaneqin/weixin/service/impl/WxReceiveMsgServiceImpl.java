package me.zaneqin.weixin.service.impl;

import java.util.List;
import me.zaneqin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.zaneqin.weixin.mapper.WxReceiveMsgMapper;
import me.zaneqin.weixin.domain.WxReceiveMsg;
import me.zaneqin.weixin.service.IWxReceiveMsgService;
import me.zaneqin.common.core.text.Convert;

/**
 * 历史消息Service业务层处理
 * 
 * @author ZaneQin
 * @date 2020-01-14
 */
@Service
public class WxReceiveMsgServiceImpl implements IWxReceiveMsgService 
{
    @Autowired
    private WxReceiveMsgMapper wxReceiveMsgMapper;

    /**
     * 查询历史消息
     * 
     * @param msgId 历史消息ID
     * @return 历史消息
     */
    @Override
    public WxReceiveMsg selectWxReceiveMsgById(String msgId)
    {
        return wxReceiveMsgMapper.selectWxReceiveMsgById(msgId);
    }

    /**
     * 查询历史消息列表
     * 
     * @param wxReceiveMsg 历史消息
     * @return 历史消息
     */
    @Override
    public List<WxReceiveMsg> selectWxReceiveMsgList(WxReceiveMsg wxReceiveMsg)
    {
        return wxReceiveMsgMapper.selectWxReceiveMsgList(wxReceiveMsg);
    }

    /**
     * 新增历史消息
     * 
     * @param wxReceiveMsg 历史消息
     * @return 结果
     */
    @Override
    public int insertWxReceiveMsg(WxReceiveMsg wxReceiveMsg)
    {
        wxReceiveMsg.setCreateTime(DateUtils.getNowDate());
        return wxReceiveMsgMapper.insertWxReceiveMsg(wxReceiveMsg);
    }

    /**
     * 修改历史消息
     * 
     * @param wxReceiveMsg 历史消息
     * @return 结果
     */
    @Override
    public int updateWxReceiveMsg(WxReceiveMsg wxReceiveMsg)
    {
        return wxReceiveMsgMapper.updateWxReceiveMsg(wxReceiveMsg);
    }

    /**
     * 删除历史消息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxReceiveMsgByIds(String ids)
    {
        return wxReceiveMsgMapper.deleteWxReceiveMsgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除历史消息信息
     * 
     * @param msgId 历史消息ID
     * @return 结果
     */
    @Override
    public int deleteWxReceiveMsgById(String msgId)
    {
        return wxReceiveMsgMapper.deleteWxReceiveMsgById(msgId);
    }
}
