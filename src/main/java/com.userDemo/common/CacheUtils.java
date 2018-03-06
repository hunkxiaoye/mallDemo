package com.userDemo.common;

import org.ehcache.UserManagedCache;
import org.ehcache.config.builders.UserManagedCacheBuilder;

public class CacheUtils {

    private static UserManagedCache<String, Object> userManagedCache;

    static {
        userManagedCache =
                UserManagedCacheBuilder.newUserManagedCacheBuilder(String.class, Object.class)
                        .build(false);
        userManagedCache.init();
    }


    public static <T> T get(String key) {
        return (T) userManagedCache.get(key);
    }

    public static void set(String key, Object value) {
        userManagedCache.put(key, value);
    }

    public static void remove(String key) {
        userManagedCache.remove(key);
    }
}
