package com.study.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("capacity:" + intBuffer.capacity());
        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(2);
            intBuffer.put(randomNumber);
        }
        System.out.println("before flip limit:" + intBuffer.limit());
        intBuffer.flip();
        System.out.println("after flip limit:" + intBuffer.limit());

        System.out.println("enter while loop");
        while (intBuffer.hasRemaining()){
            System.out.println("position:" + intBuffer.position());
            System.out.println("limit:" + intBuffer.limit());
            System.out.println("capacity:" + intBuffer.capacity());
            System.out.println(intBuffer.get());
        }
    }
}
