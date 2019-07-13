package com.ykmimi.rabbitmqfanout;

import com.ykmimi.rabbitmqfanout.customer.TestCustomer;
import com.ykmimi.rabbitmqfanout.producer.TestProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RabbitmqFanoutApplication {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        TestCustomer.startCustomer();
        Thread.sleep(3000);
        TestCustomer.startCustomer();
        Thread.sleep(3000);
        TestProducer.startProducer();

//        SpringApplication.run(RabbitmqFanoutApplication.class, args);
    }

}
