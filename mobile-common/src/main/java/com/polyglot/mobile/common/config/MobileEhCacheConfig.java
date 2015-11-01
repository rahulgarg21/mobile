package com.polyglot.mobile.common.config;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

import javax.management.MBeanServer;

/**
 * Created by Rajiv Singla on 10/18/2015.
 */

@Configuration
@Import(value = {MobileJMXConfig.class, MobileAsyncConfig.class})
public class MobileEhCacheConfig {

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(final EhCacheManagerFactoryBean ehCacheManagerFactoryBean) {
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        final EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("META-INF/cache/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }


    @Bean(destroyMethod = "dispose")
    @Lazy(value = false)
    public ManagementService managementService(final CacheManager ehCacheManager,
                                               final MBeanServer mBeanServer) {
        final ManagementService managementService = new ManagementService(ehCacheManager, mBeanServer, true, true, true, true);
        managementService.init();
        return managementService;
    }


}
