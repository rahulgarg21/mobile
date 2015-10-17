package com.polyglot.mobile.common.config;

import com.polyglot.mobile.common.appconfig.NYTimesKeySource;
import com.polyglot.mobile.common.appconfig.impl.NYTimesKeySourceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
@Configuration
public class MobileAppPropertiesConfig {

    @Bean
    public NYTimesKeySource nyTimesKeySource() {
        return new NYTimesKeySourceImpl();
    }
}
