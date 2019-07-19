package com.study.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true){
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();
            for (SelectionKey selectKey: keySet) {
                if(selectKey.isConnectable()){
                    SocketChannel client = (SocketChannel) selectKey.channel();
                    if(client.isConnectionPending()){
                        client.finishConnect();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                        writeBuffer.flip();
                        client.write(writeBuffer);

                        ExecutorService executorService = Executors.newSingleThreadExecutor();
                        executorService.submit(()->{
                           while (true){
                               writeBuffer.clear();
                               InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                               BufferedReader br = new BufferedReader(inputStreamReader);
                               String sendMessage = br.readLine();
                               writeBuffer.put(sendMessage.getBytes());
                               writeBuffer.flip();
                               client.write(writeBuffer);
                           }
                        });
                    }

                    client.register(selector, SelectionKey.OP_READ);

                }else if(selectKey.isReadable()){
                    SocketChannel client = (SocketChannel) selectKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int count = client.read(readBuffer);
                    if(count > 0){
                        String receivedMessage = new String(readBuffer.array(), 0, count);
                        System.out.println(receivedMessage);
                    }
                }
            }
            keySet.clear();
        }
    }
}
