package com.study.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    //ctx上下文信息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //远程地址端口号
        System.out.println(ctx.channel().remoteAddress() +", "+ msg);
        ctx.channel().writeAndFlush("from server: " + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        //异常处理
        cause.printStackTrace();
        ctx.close();
    }
}
