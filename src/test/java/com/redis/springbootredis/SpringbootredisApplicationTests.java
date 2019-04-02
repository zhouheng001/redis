package com.redis.springbootredis;

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

	@Test
	public void contextLoads() {
//		stringRedisTemplate.opsForValue().set("zhou","jjsjf");
//		Set<String> zhou = stringRedisTemplate.keys("zhou");
//		stringRedisTemplate.opsForZSet().add("1","123",5);
//		stringRedisTemplate.opsForZSet().add("1","123456",4);
//		stringRedisTemplate.opsForZSet().add("1","1234",8);


		Set<String> range = stringRedisTemplate.opsForZSet().range("1", 0, -1);
		Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore("1", 4, 5);
		Set<String> strings1 = stringRedisTemplate.opsForZSet().reverseRangeByScore("1",1,3);
		for (String s : strings1) {
			System.out.println(s);
		}

	}

}
