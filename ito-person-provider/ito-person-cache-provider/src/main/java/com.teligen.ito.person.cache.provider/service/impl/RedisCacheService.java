package com.teligen.ito.person.cache.provider.service.impl;

import com.teligen.ito.person.cache.provider.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisCacheService implements ICacheService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean put(String namespace, String key, String value) {
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    @Override
    public String get(String namespace, String key) {
        String value=redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public Map<String, Object> get(String namespace, List<String> keys) {
        return null;
    }

    @Override
    public boolean put(String namespace, Map<String, Object> map) {
        return false;
    }
}
