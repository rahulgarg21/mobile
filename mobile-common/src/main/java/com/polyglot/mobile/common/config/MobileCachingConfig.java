package com.polyglot.mobile.common.config;

import net.sf.ehcache.management.ManagementService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import javax.management.MBeanServer;

/**
 * Created by Rajiv Singla on 10/1/2015.
 */
@Configuration
@EnableCaching
@Import(value = {MobileJMXConfig.class, MobileAsyncConfig.class})
public class MobileCachingConfig {

    @Bean
    @Primary
    public CacheManager compositeCacheManager(final EhCacheCacheManager ehCacheCacheManager) {
        final CompositeCacheManager compositeCacheManager = new CompositeCacheManager(ehCacheCacheManager);
        return compositeCacheManager;
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(final EhCacheManagerFactoryBean ehCacheManagerFactoryBean) {
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        final EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("META-INF/cache/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        ehCacheManagerFactoryBean.afterPropertiesSet();
        return ehCacheManagerFactoryBean;
    }

    @Bean(initMethod = "init",destroyMethod = "dispose")
    public ManagementService managementService(final net.sf.ehcache.CacheManager  ehCacheManager, MBeanServer mBeanServer) {
        final ManagementService managementService = new ManagementService(ehCacheManager,mBeanServer,true,true,true,true);
        return managementService;
    }



}
