package com.polyglot.mobile.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.*;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rajiv Singla on 10/1/2015.
 */
@Configuration
@EnableCaching
@Import(value = {MobileEhCacheConfig.class})
public class MobileCachingConfig implements CachingConfigurer {

    @Autowired(required = true)
    @Qualifier("ehCacheCacheManager")
    private CacheManager ehCacheCacheManager;

    @Override
    @Bean
    public CacheManager cacheManager() {
        final CompositeCacheManager compositeCacheManager = new CompositeCacheManager(ehCacheCacheManager);
        compositeCacheManager.setFallbackToNoOpCache(false);
        return compositeCacheManager;
    }

    @Override
    @Bean
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver(cacheManager());
    }

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    @Bean
    public CacheErrorHandler errorHandler() {
        return new SimpleCacheErrorHandler();
    }
}
