package com.ykmimi.rabbitmqfanout.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ykmimi.rabbitmqfanout.util.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestProducer {

    public final static String EXCHANGE_NAME = "fanout_exchange";

    public static void startProducer() throws IOException, TimeoutException {
        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //声明要使用的交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //产生消息
        for(int i=0; i<100;i++){
            String message = "direct 消息"+i;
            //发送消息到队列中
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes("UTF-8"));
            System.out.println("发送消息:"+message);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
