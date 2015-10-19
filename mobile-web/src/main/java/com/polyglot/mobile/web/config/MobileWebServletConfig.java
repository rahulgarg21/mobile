package com.polyglot.mobile.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Created by Rajiv Singla on 10/20/2015.
 */

@Configuration
@ComponentScan(basePackages = {"com.polyglot.mobile.web.controllers"})
@EnableSpringDataWebSupport
public class MobileWebServletConfig {
}
