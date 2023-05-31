package com.abin.mallchat.common.common.config;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
public class WebContext {

    private static ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(Channel channel) {
        THREAD_LOCAL.set(new Context(Optional.ofNullable(channel)));
    }

    public static Context get() {
        return THREAD_LOCAL.get();
    }

    public static void reset() {
        THREAD_LOCAL.remove();
    }

    public static Channel getChannel() {
        return get().getChannel();
    }

    @Data
    @AllArgsConstructor
    public static class Context {

        private Optional<Channel> channel;

        public Channel getChannel() {
            return channel.get();
        }

    }
}
