package com.polyglot.mobile.testsupport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */

@Configuration
public class MobileTestSupportConfig {


    @Profile("unit-test")
    @Configuration
    @PropertySource("classpath:unit-test.properties")
    public static class UnitTestProperties {
    }


    @Profile("integration-test")
    @Configuration
    @PropertySource("classpath:integration-test.properties")
    public static class IntegrationTestProperties {
    }


}
