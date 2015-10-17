package com.polyglot.mobile.persistence.config;

import com.polyglot.mobile.persistence.auditing.impl.DateTimeProviderImpl;
import com.polyglot.mobile.persistence.auditing.impl.SpringSecurityAuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider", auditorAwareRef = "auditorProvider")
@Configuration
public class MobileJpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditorAwareImpl();
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return new DateTimeProviderImpl();
    }

}
