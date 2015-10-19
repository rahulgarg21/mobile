package com.polyglot.mobile.war.config;

import com.polyglot.mobile.web.config.MobileWebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Rajiv Singla on 10/17/2015.
 */
@Configuration
@Import(value = {MobileWebConfig.class})
@PropertySource("classpath:database.properties")
public class MobileWarConfig {
}
