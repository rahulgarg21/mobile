package com.polyglot.mobile.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */

@Configuration
@Import(value = {MobileCommonConfig.class})
public class MobileCommonTestConfig {
}
