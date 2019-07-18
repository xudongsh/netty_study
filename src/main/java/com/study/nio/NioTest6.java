package com.study.nio;

import java.nio.ByteBuffer;

/**
 * Slice Buffer 与原有buffer共享相同的底层数组，就是引用相同的内存地址
 */
public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer sliceBuffer = byteBuffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *=2;
            sliceBuffer.put(i, b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while(byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
    }
}
