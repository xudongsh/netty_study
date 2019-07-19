package com.study.nio;

import io.netty.util.CharsetUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class NioTest13 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "";
        String outputFile = "";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(inputFile, "rw");

        Charset charset = Charset.forName("gbk");

    }
}
