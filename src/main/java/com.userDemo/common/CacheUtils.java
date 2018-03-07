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
import java.util.concurrent.TimeUnit;

public class CacheUtils {

//    private static UserManagedCache<String, Object> userManagedCache;
//
//    static {
//        userManagedCache =
//                UserManagedCacheBuilder.newUserManagedCacheBuilder(String.class, Object.class)
//                        .build(false);
//        userManagedCache.init();
//    }
//
//
//    public static <T> T get(String key) {
//        return (T) userManagedCache.get(key);
//    }
//
//    public static void set(String key, Object value) {
//        userManagedCache.put(key, value);
//    }
//
//    public static void remove(String key) {
//        userManagedCache.remove(key);
//    }
private static CacheManager cacheManager;
static {

 cacheManager = CacheManagerBuilder
        .newCacheManagerBuilder()
        .withCache(
                "defaults",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        String.class, Object.class,
                        ResourcePoolsBuilder.heap(100))
                        .withExpiry(Expirations.timeToLiveExpiration(Duration.of(20, TimeUnit.SECONDS)))
                        .build())
        .build(true);


}
public static Cache<String, Object> typeCache(int type)
{
     Cache<String, Object> myCache = null ;
    switch (type)
    {
        case 1:
              myCache = cacheManager.getCache(
            "defaults", String.class, Object.class);
        break;
        case 2:
            cacheManager.createCache(
                    "myCache",
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(
                            String.class, Object.class,
                            ResourcePoolsBuilder.heap(100))
                            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(20, TimeUnit.SECONDS)))
                            .build());
            break;

    }
    return myCache;
}


    public static <T> T get(String key,int type) {

        return (T) typeCache(type).get(key);
    }

    public static void set(String key, Object value,int type) {
        typeCache(type).put(key, value);
    }

    public static void remove(String key,int type) {
        typeCache(type).remove(key);
    }
}
