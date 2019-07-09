package com.study.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyMessage myMessage = null;

        int randomInt = new Random().nextInt(3);
        if(0 == randomInt){
            MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                    .setName("张三")
                    .setAge(20)
                    .setAddress("北京")
                    .build();
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(person)
                    .build();
        }else if(1 == randomInt){
            MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder()
                    .setName("泰迪")
                    .setAge(3)
                    .build();
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(dog)
                    .build();
        }else{
            MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder()
                    .setName("英短")
                    .setCity("大连")
                    .build();
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(cat)
                    .build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
