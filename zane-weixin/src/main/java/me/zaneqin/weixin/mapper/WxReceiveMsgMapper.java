package me.zaneqin.weixin.mapper;

import me.zaneqin.weixin.domain.WxReceiveMsg;
import java.util.List;

/**
 * 历史消息Mapper接口
 * 
 * @author ZaneQin
 * @date 2020-01-14
 */
public interface WxReceiveMsgMapper 
{
    /**
     * 查询历史消息
     * 
     * @param msgId 历史消息ID
     * @return 历史消息
     */
    public WxReceiveMsg selectWxReceiveMsgById(String msgId);

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
     * 删除历史消息
     * 
     * @param msgId 历史消息ID
     * @return 结果
     */
    public int deleteWxReceiveMsgById(String msgId);

    /**
     * 批量删除历史消息
     * 
     * @param msgIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxReceiveMsgByIds(String[] msgIds);
}
