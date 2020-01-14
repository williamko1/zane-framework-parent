package me.zaneqin.weixin.service;

import me.zaneqin.weixin.domain.WxReceiveMsg;
import java.util.List;

/**
 * 历史消息Service接口
 * 
 * @author ZaneQin
 * @date 2020-01-14
 */
public interface IWxReceiveMsgService 
{
    /**
     * 查询历史消息
     * 
     * @param msgId 历史消息ID
     * @return 历史消息
     */
    public WxReceiveMsg selectWxReceiveMsgById(Long msgId);

    /**
     * 查询历史消息列表
     * 
     * @param wxReceiveMsg 历史消息
     * @return 历史消息集合
     */
    public List<WxReceiveMsg> selectWxReceiveMsgList(WxReceiveMsg wxReceiveMsg);

    /**
     * 新增历史消息
     * 
     * @param wxReceiveMsg 历史消息
     * @return 结果
     */
    public int insertWxReceiveMsg(WxReceiveMsg wxReceiveMsg);

    /**
     * 修改历史消息
     * 
     * @param wxReceiveMsg 历史消息
     * @return 结果
     */
    public int updateWxReceiveMsg(WxReceiveMsg wxReceiveMsg);

    /**
     * 批量删除历史消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxReceiveMsgByIds(String ids);

    /**
     * 删除历史消息信息
     * 
     * @param msgId 历史消息ID
     * @return 结果
     */
    public int deleteWxReceiveMsgById(Long msgId);
}
