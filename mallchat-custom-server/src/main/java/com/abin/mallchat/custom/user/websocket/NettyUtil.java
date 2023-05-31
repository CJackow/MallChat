package com.abin.mallchat.custom.user.websocket;

import com.abin.mallchat.common.common.config.WebContext;
import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 * Description: netty工具类
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-04-18
 */

public class NettyUtil {

    public static AttributeKey<String> IP = AttributeKey.valueOf("ip");

    public static <T> void setAttr(AttributeKey<T> attributeKey, T data) {
        Attribute<T> attr = WebContext.getChannel().attr(attributeKey);
        attr.set(data);
    }

    public static <T> T getAttr(AttributeKey<T> ip) {
        return WebContext.getChannel().attr(ip).get();
    }
}
