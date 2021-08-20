package com.example.demo;

//import com.example.demo.entity.User;
//import com.example.demo.until.RedisUtil;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@SpringBootTest(classes = DemoApplication.class)
//@RunWith(SpringRunner.class)
//class DemoApplicationTests {
//    @Autowired
//    private RabbitTemplate redisTemplate;
//    @Test
//    public void test2(){
//
//        redisTemplate.convertAndSend("work","hello work");
//    }
//    @Test
//    public void test(){
//
//        redisTemplate.convertAndSend("hello","hello world");
//    }
//    @Test
//    void contextLoads() {
//        //redisTemplate 操作不同数据类型
//        //opsForValue 字符串操作
//        //opsForList 列表操作
//        //opsForSet 集合操作
//        //....
//
//        //除了基本操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的curd
//        //获取连接对象
////        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
////        connection.flushDb();
//        redisTemplate.opsForValue().set("mykey", "lin");
//        System.out.println(redisTemplate.opsForValue().get("mykey"));
//
//    }
//
//    @Test
//    public void dfjk() {
//        User user = new User("guo", 19);
//        redisTemplate.opsForValue().set("user", user);
//        System.out.println(redisTemplate.opsForValue().get("user"));
//    }
//}
