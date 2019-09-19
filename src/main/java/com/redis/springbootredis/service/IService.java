package com.redis.springbootredis.service;

import org.springframework.cache.annotation.CacheEvict;

public interface IService {

    String ttest1();

    void clean();
}
