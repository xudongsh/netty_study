package com.study.netty.fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeLine = ch.pipeline();
        pipeLine.addLast(new HttpServerCodec());
        pipeLine.addLast(new ChunkedWriteHandler());
        pipeLine.addLast(new HttpObjectAggregator(8192));
        pipeLine.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeLine.addLast(new TextWebSocketFrameHandler());
    }
}
