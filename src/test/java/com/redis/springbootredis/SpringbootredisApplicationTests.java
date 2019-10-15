package com.redis.springbootredis;

import com.redis.springbootredis.service.IService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootredisApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private IService service;

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("zhou", 1000+"");
//		Set<String> zhou = stringRedisTemplate.keys("zhou");
//		stringRedisTemplate.opsForZSet().add("1","123",5);
//		stringRedisTemplate.opsForZSet().add("1","123456",4);
//		stringRedisTemplate.opsForZSet().add("1","1234",8);


//		Set<String> range = stringRedisTemplate.opsForZSet().range("1", 0, -1);
//		Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore("1", 4, 5);
//		Set<String> strings1 = stringRedisTemplate.opsForZSet().reverseRangeByScore("1",1,3);
//		for (String s : strings1) {
//			System.out.println(s);
//		}

//        service.clean();
//
//        String s = service.ttest1();
//        System.out.println(s);

        String zhou1 = stringRedisTemplate.opsForValue().get("zhou");
        System.out.println(zhou1);
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    stringRedisTemplate.opsForValue().increment("zhou", 1);
                    stringRedisTemplate.opsForValue().increment("zhou", -1);
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String zhou = stringRedisTemplate.opsForValue().get("zhou");
        System.out.println(zhou);

    }

}
