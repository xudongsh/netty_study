package com.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("E:\\sql.txt");
        FileOutputStream outputStream = new FileOutputStream("E:\\output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            buffer.clear();

            int read = inputChannel.read(buffer);
            System.out.println("read" + read);

            if(read < 0 ){
                break;
            }

            buffer.flip();

            outputChannel.write(buffer);
        }

        inputChannel.close();
        outputChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
