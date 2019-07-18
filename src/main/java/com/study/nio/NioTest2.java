package com.study.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\sql.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuf = ByteBuffer.allocate(512);
        fileChannel.read(byteBuf);
        byteBuf.flip();

        while (byteBuf.remaining() > 0){
            byte b = byteBuf.get();
            System.out.println("Character:" + (char)b);
        }
        fileInputStream.close();
    }
}
