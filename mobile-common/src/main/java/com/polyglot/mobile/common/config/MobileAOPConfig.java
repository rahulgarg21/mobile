package com.polyglot.mobile.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Rajiv Singla on 10/18/2015.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.polyglot.mobile.common.aspects")
public class MobileAOPConfig {

}
