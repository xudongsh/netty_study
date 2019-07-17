package com.study.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899)
                .addService(new StudentServiceImpl()).build().start();

        System.out.println("server started!");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("关闭JVM");
            GrpcServer.this.stop();
        }));
//        System.out.println("执行到这里");
    }

    private void stop(){
        if (null != this.server){
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if(null != this.server){
//            this.server.awaitTermination(3000, TimeUnit.MILLISECONDS);
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        GrpcServer server = new GrpcServer();
        server.start();
        //保证服务处于阻塞状态
        server.awaitTermination();
    }
}
