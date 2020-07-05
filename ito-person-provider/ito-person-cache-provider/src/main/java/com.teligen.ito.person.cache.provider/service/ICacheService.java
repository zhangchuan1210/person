package com.teligen.ito.person.cache.provider.service;

import java.util.List;
import java.util.Map;

public interface ICacheService {

    boolean put(String namespace, String key, String value);
    String get(String namespace, String key);
    Map<String,Object> get(String namespace, List<String> keys);
    boolean put(String namespace, Map<String, Object> map);

}
