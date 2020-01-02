package me.zaneqin.weixin.mp.config;

import lombok.Data;
import me.zaneqin.weixin.mp.utils.JsonUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * yml配置映射成实体类
 * @author : Zane Qin
 * createTime : 10:31 2019/10/10
 * modifier :
 * modifyTime :
 */
@Data
@ConfigurationProperties(prefix = "wx.mp")
public class WxMpProperties {
    private List<MpConfig> configs;

    @Data
    public static class MpConfig {
        /**
         * 设置微信公众号的appid
         */
        private String appId;

        /**
         * 设置微信公众号的app secret
         */
        private String secret;

        /**
         * 设置微信公众号的token
         */
        private String token;

        /**
         * 设置微信公众号的EncodingAESKey
         */
        private String aesKey;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
