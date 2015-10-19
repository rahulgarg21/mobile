package com.polyglot.mobile.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Configuration
@Import(value = {MobilePersistenceConfig.class})
@EnableJpaAuditing(auditorAwareRef = "mockAuditorProvider")
public class MobilePersistenceTestConfig {

    @Bean
    public AuditorAware<String> mockAuditorProvider() {
        return new AuditorAware<String>() {
            @Override
            public String getCurrentAuditor() {
                String username = System.getProperty("user.name");
                return username != null ? username : "UnknownUser";
            }
        };
    }

}
