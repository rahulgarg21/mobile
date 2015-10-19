package com.polyglot.mobile.web.config;

import com.polyglot.mobile.business.config.MobileBusinessConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rajiv Singla on 10/17/2015.
 */
@Configuration
@Import(value = {MobileBusinessConfig.class})
public class MobileWebConfig {
}
