package com.polyglot.mobile.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.assembler.MetadataMBeanInfoAssembler;
import org.springframework.jmx.export.metadata.JmxAttributeSource;
import org.springframework.jmx.export.naming.MetadataNamingStrategy;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.management.MBeanServer;

/**
 * Created by Rajiv Singla on 10/1/2015.
 */
@Configuration
public class MobileJMXConfig {



    @Bean
    public MBeanExporter mBeanExporter(final MBeanServer mBeanServer,final ObjectNamingStrategy namingStrategy,
                                       final MetadataMBeanInfoAssembler metadataMBeanInfoAssembler) {
        final MBeanExporter mBeanExporter = new MBeanExporter();
        mBeanExporter.setServer(mBeanServer);
        mBeanExporter.setAutodetect(true);
        mBeanExporter.setNamingStrategy(namingStrategy);
        mBeanExporter.setAssembler(metadataMBeanInfoAssembler);
        mBeanExporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        return mBeanExporter;
    }

    @Bean
    public MBeanServer mBeanServer() {
        final MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
        mBeanServerFactoryBean.setLocateExistingServerIfPossible(true);
        mBeanServerFactoryBean.setDefaultDomain("com.polyglot.mobile");
        mBeanServerFactoryBean.afterPropertiesSet();
        return mBeanServerFactoryBean.getObject();
    }

    // will create management interface using annotation metadata
    @Bean
    public MetadataMBeanInfoAssembler metadataMBeanInfoAssembler(final JmxAttributeSource jmxAttributeSource) {
        final MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
        metadataMBeanInfoAssembler.setAttributeSource(jmxAttributeSource);
        return metadataMBeanInfoAssembler;
    }

    // Will pick up the ObjectName from the annotation
    @Bean
    public ObjectNamingStrategy namingStrategy(final JmxAttributeSource jmxAttributeSource) {
        final MetadataNamingStrategy metadataNamingStrategy =
                new MetadataNamingStrategy(jmxAttributeSource);
        return metadataNamingStrategy;
    }

    @Bean
    public JmxAttributeSource jmxAttributeSource() {
        return new AnnotationJmxAttributeSource();
    }

}
