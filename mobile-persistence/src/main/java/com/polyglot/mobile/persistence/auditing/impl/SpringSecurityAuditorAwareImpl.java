package com.polyglot.mobile.persistence.auditing.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
public class SpringSecurityAuditorAwareImpl implements AuditorAware<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringSecurityAuditorAwareImpl.class);

    @Override
    public String getCurrentAuditor() {

        LOGGER.debug("Getting user name of authenticated user from Spring Security Context.");

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {
            LOGGER.warn("Cannot determine authenticaed user name");
            return null;
        }

        final String username = ((User) authentication.getPrincipal()).getUsername();

        LOGGER.debug("Found authenticated username: {}", username);

        return username;
    }
}
