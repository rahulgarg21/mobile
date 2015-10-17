package com.polyglot.mobile.common.util.spring.impl;

import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.common.util.spring.JdbcPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StopWatch;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkState;
import static com.polyglot.mobile.common.MobileConstants.*;
import static com.polyglot.mobile.common.MobileConstants.PROPS_QUERY_STRING;

/**
 * Created by Rajiv Singla on 10/7/2015.
 */
@Slf4j
public class JdbcPropertySourceImpl extends PropertySource<DataSource> implements JdbcPropertySource {

    private final RemovalListener<AppEnvironment, Map<String,String>> propertyCacheRemovalListener =
            new RemovalListener<AppEnvironment,Map<String,String>>() {
                @Override
                public void onRemoval(final RemovalNotification<AppEnvironment, Map<String,String>> notification) {
                    log.debug("Property Cache Eviction Notification Triggered due to eviction of: {}:{}",
                            notification.getKey(),notification.getValue());
                    loadPropertyCache();
                }
            };

    private final Cache<AppEnvironment,Map<String,String>> propertyCache = CacheBuilder.newBuilder()
            .expireAfterAccess(PROPS_CACHE_DURATION_SECONDS, TimeUnit.SECONDS)
            .removalListener(propertyCacheRemovalListener)
            .build();


    private final AppEnvironment currentAppEnvironment;
    private final DataSource dataSource;

    public JdbcPropertySourceImpl(final DataSource dataSource, final AppEnvironment appEnvironment) {
        super("jdbcPropertySource", dataSource);
        this.currentAppEnvironment = appEnvironment;
        this.dataSource = dataSource;
        loadPropertyCache();
    }

    @Override
    public Object getProperty(String name) {

        final Map<String, String> currentAppEnvironmentProps = propertyCache.getIfPresent(currentAppEnvironment);
        checkState(currentAppEnvironmentProps != null, "Cache must contain currentAppEnvironment " + currentAppEnvironment.name());

        final String currentEnvironmentValue = currentAppEnvironmentProps.get(name);
        if(currentEnvironmentValue != null) {
            log.debug("Found Property Key: {} in App Environment: {}", name, currentAppEnvironment.name());
            return currentEnvironmentValue;
        }

        final Map<String, String> defaultAppEnvironmentProps = propertyCache.getIfPresent(DEFAULT_PROPS_ENVIRONMENT);
        checkState(defaultAppEnvironmentProps != null, "Cache must contain defaultAppEnvironment " + DEFAULT_PROPS_ENVIRONMENT.name());

        final String defaultPropertyValue = defaultAppEnvironmentProps.get(name);
        if(defaultPropertyValue != null) {
            log.debug("Found Property Key: {} in Default App Environment: {}", name, DEFAULT_PROPS_ENVIRONMENT.name());
        }

        return defaultPropertyValue;
    }

    @Override
    public void loadPropertyCache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Stopwatch stopwatch = Stopwatch.createStarted();
                log.debug("Starting Properties Cache Loading");
                final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                final List<JdbcPropertyEntity> jdbcPropertyEntityList =
                        jdbcTemplate.query(PROPS_QUERY_STRING, new JdbcPropertyEntityRowMapper());
                for (JdbcPropertyEntity jdbcPropertyEntity : jdbcPropertyEntityList) {
                    final AppEnvironment dbAppEnvironment = jdbcPropertyEntity.getAppEnvironment();
                    final Map<String, String> cachedAppEnvironmentProps = propertyCache.getIfPresent(dbAppEnvironment);
                    if(cachedAppEnvironmentProps != null) {
                        cachedAppEnvironmentProps.put(jdbcPropertyEntity.getPropertyKey(),jdbcPropertyEntity.getPropertyValue());
                    } else {
                        final HashMap<String, String> newPropertiesMap = new HashMap<>();
                        newPropertiesMap.put(jdbcPropertyEntity.getPropertyKey(), jdbcPropertyEntity.getPropertyValue());
                        propertyCache.put(dbAppEnvironment,newPropertiesMap);
                    }
                }
                log.debug("Finished loading Properites Cache. Time taken: {}", stopwatch.stop());
            }
        }).start();
    }

    @Override
    public Map<AppEnvironment,Map<String, String>> getAllCachedProperties() {
        return propertyCache.asMap();
    }

    @Override
    public void evictPropertyCache() {
        propertyCache.invalidateAll();
    }
}
