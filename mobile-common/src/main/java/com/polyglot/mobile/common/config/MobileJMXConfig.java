package com.polyglot.mobile.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Lazy;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import javax.management.MBeanServer;

/**
 * Created by Rajiv Singla on 10/1/2015.
 */
@Configuration
@EnableMBeanExport(server = "mBeanServer", defaultDomain = "com.polyglot.mobile")
public class MobileJMXConfig {

    @Bean
    public MBeanServer mBeanServer() {
        final MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
        mBeanServerFactoryBean.setDefaultDomain("com.polyglot.mobile");
        mBeanServerFactoryBean.setRegisterWithFactory(true);
        mBeanServerFactoryBean.afterPropertiesSet();
        return mBeanServerFactoryBean.getObject();
    }

}
