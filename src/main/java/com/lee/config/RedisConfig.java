package com.lee.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.redisson.spring.cache.CacheConfig;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liw
 * @description :
 * @date : 2018/6/29 11:31
 */
@Configuration
public class RedisConfig {
    public static final String CACHE_NAME = "test_lock";

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + "redis.ops.com" + ":6400")
                .setPassword("tbbdev")
                .setDatabase(29);
        return Redisson.create(config);
    }

    @Bean
    public CacheManager cacheManager(){
        Map<String, CacheConfig> map = new HashMap<>();
        map.put(CACHE_NAME, new CacheConfig(60 * 60 * 1000, 10 * 60 * 1000));
        return new RedissonSpringCacheManager(redisson(), map);
    }

}
