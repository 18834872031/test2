package com.example.demo.config;

//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
//@Configuration
//public class RabbitConfig {
//
//    final static String queueNameA = "first-queue";
//    final static String queueNameB = "second-queue";
//
//    /***
//     * 定义一个队列，设置队列属性
//     * @return
//     */
//    @Bean("queueA")
//    public Queue queueA() {
//
//        Map<String, Object> map = new HashMap<>();
//        // 消息过期时长，10秒过期
//        map.put("x-message-ttl", 10000);
//        // 队列中最大消息条数，10条
//        map.put("x-max-length", 10);
//        // 第一个参数，队列名称
//        // 第二个参数，durable：持久化
//        // 第三个参数，exclusive：排外的，
//        // 第四个参数，autoDelete：自动删除
//        Queue queue = new Queue(queueNameA, true, false, false, map);
//        return queue;
//    }
//
//    @Bean("queueB")
//    public Queue queueB() {
//
//        Map<String, Object> map = new HashMap<>();
//        // 消息过期时长，10秒过期
//        map.put("x-message-ttl", 10000);
//        // 队列中最大消息条数，10条
//        map.put("x-max-length", 10);
//        // 第一个参数，队列名称
//        // 第二个参数，durable：持久化
//        // 第三个参数，exclusive：排外的，
//        // 第四个参数，autoDelete：自动删除
//        Queue queue = new Queue(queueNameB, true, false, false, map);
//        return queue;
//    }
//}


