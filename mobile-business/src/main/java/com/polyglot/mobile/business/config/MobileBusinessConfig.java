package com.polyglot.mobile.business.config;

import com.polyglot.mobile.persistence.config.MobilePersistenceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rajiv Singla on 10/17/2015.
 */
@Configuration
@Import(value = {MobilePersistenceConfig.class})
public class MobileBusinessConfig {
}
