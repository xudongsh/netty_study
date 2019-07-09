package com.study.netty.sixthexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new TestClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            channel.closeFuture().sync();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            while(true){
//                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
//            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
