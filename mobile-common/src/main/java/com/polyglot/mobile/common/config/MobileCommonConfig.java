package com.polyglot.mobile.common.config;

import com.polyglot.mobile.common.util.spring.impl.JdbcAwarePropertySourcesPlaceholderConfigurer;
import com.polyglot.mobile.common.util.spring.impl.JdbcPropertyEntityRowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static com.polyglot.mobile.common.MobileConstants.PROPS_QUERY_STRING;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
@Configuration
@Import(value = {MobileCachingConfig.class, MobileAppPropertiesConfig.class, MobileAOPConfig.class})
public class MobileCommonConfig {

    @Bean
    public static JdbcAwarePropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() throws Exception {
        JdbcAwarePropertySourcesPlaceholderConfigurer jdbcAwarePropertySourcesPlaceholderConfigurer
                = new JdbcAwarePropertySourcesPlaceholderConfigurer(
                new String[]{"META-INF/sql/config.sql", "META-INF/sql/propertiesData.sql"},
                PROPS_QUERY_STRING,
                new JdbcPropertyEntityRowMapper());
        return jdbcAwarePropertySourcesPlaceholderConfigurer;
    }


}
