package com.userDemo.common;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.UserManagedCache;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePool;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheUtils {

    private static CacheManager cacheManager;
    private static HashMap<Integer, Cache<String, Object>> hashMap = new HashMap<>();
    private static Cache<String, Object> myCache;

    static {
        cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder()
                .withCache(
                        "10",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                String.class, Object.class,
                                ResourcePoolsBuilder.heap(10000))
                                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(10, TimeUnit.SECONDS)))
                                .build())
                .build(true);
    }



    public static <T> T get(String key, int time) {
        if(hashMap.containsKey(time))
        {
            myCache =hashMap.get(time) ;
            return (T)myCache.get(key);
        }
          return null;
    }

    public static void set(String key, Object value, int time) {
        if (!hashMap.containsKey(time))
        {
            myCache = cacheManager.createCache(
                    time + "",
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(
                            String.class, Object.class,
                            ResourcePoolsBuilder.heap(100))
                            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(time, TimeUnit.SECONDS)))
                            .build());
            hashMap.put(time, myCache);
        }
        myCache.put(key, value);


    }

    public static void remove(String key, int time) {
        if(hashMap.get(time)!=null) {
            myCache = hashMap.get(time);
            myCache.remove(key);
        }
    }
}
