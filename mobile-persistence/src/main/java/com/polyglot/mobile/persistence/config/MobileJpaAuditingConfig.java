package com.polyglot.mobile.persistence.config;

import com.polyglot.mobile.persistence.auditing.DateTimeService;
import com.polyglot.mobile.persistence.auditing.impl.AuditingDateTimeProvider;
import com.polyglot.mobile.persistence.auditing.impl.DateTimeServiceImpl;
import com.polyglot.mobile.persistence.auditing.impl.SpringSecurityAuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class MobileJpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditorAwareImpl();
    }

    @Bean
    public DateTimeService dateTimeService() {
        return  new DateTimeServiceImpl();
    }

    @Bean
    public DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
        return new AuditingDateTimeProvider(dateTimeService);
    }
}
