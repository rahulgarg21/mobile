package com.polyglot.mobile.common.util.spring.impl;

import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.common.util.spring.JdbcPropertyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
public class JdbcAwarePropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer implements EnvironmentAware {

    private MutablePropertySources propertySources;
    private PropertySources appliedPropertySources;
    private Environment environment;
    private final String[] jdbcSqlScripts;
    private final String jdbcQueryString;
    private final RowMapper<JdbcPropertyEntity> jdbcPropertyEntityRowMapper;


    public JdbcAwarePropertySourcesPlaceholderConfigurer(final String[] jdbcSqlScripts,
                                                         final String jdbcQueryString, final RowMapper<JdbcPropertyEntity> jdbcPropertyEntityRowMapper) {
        this.jdbcSqlScripts = jdbcSqlScripts;
        this.jdbcQueryString = jdbcQueryString;
        this.jdbcPropertyEntityRowMapper = jdbcPropertyEntityRowMapper;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (this.propertySources == null) {
            this.propertySources = new MutablePropertySources();
            if (this.environment != null) {
                this.propertySources.addLast(
                        new PropertySource<Environment>(ENVIRONMENT_PROPERTIES_PROPERTY_SOURCE_NAME, this.environment) {
                            @Override
                            public String getProperty(String key) {
                                return this.source.getProperty(key);
                            }
                        }
                );
                this.propertySources.addLast(createJdbcPropertySource());
            }
            try {
                PropertySource<?> localPropertySource =
                        new PropertiesPropertySource(LOCAL_PROPERTIES_PROPERTY_SOURCE_NAME, mergeProperties());
                if (this.localOverride) {
                    this.propertySources.addFirst(localPropertySource);
                } else {
                    this.propertySources.addLast(localPropertySource);
                }
            } catch (IOException ex) {
                throw new BeanInitializationException("Could not load properties", ex);
            }
        }

        processProperties(beanFactory, new PropertySourcesPropertyResolver(this.propertySources));
        this.appliedPropertySources = this.propertySources;
    }

    /**
     * Returns the property sources that were actually applied during
     * {@link #postProcessBeanFactory(ConfigurableListableBeanFactory) post-processing}.
     *
     * @return the property sources that were applied
     * @throws IllegalStateException if the property sources have not yet been applied
     * @since 4.0
     */
    public PropertySources getAppliedPropertySources() throws IllegalStateException {
        Assert.state(this.appliedPropertySources != null, "PropertySources have not get been applied");
        return this.appliedPropertySources;
    }

    /**
     * Customize the set of {@link PropertySources} to be used by this configurer.
     * Setting this property indicates that environment property sources and local
     * properties should be ignored.
     *
     * @see #postProcessBeanFactory
     */
    public void setPropertySources(PropertySources propertySources) {
        this.propertySources = new MutablePropertySources(propertySources);
    }

    private PropertySource createJdbcPropertySource() {
        final String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0) {
            logger.error("No spring active profile found. Skipping adding JDBC properties datasource");
        }
        if (activeProfiles.length > 1) {
            logger.warn("Multiple spring profile detected: " + Arrays.toString(activeProfiles)
                    + "Will only use first profile: " + activeProfiles[0]);
        }
        final AppEnvironment appEnvironment = AppEnvironment.appEnvironmentNameMap.get(activeProfiles[0]);

        final String dbDriver = environment.getProperty("db.driver");
        final String dbUrl = environment.getProperty("db.url");
        final String dbUsername = environment.getProperty("db.username");
        final String dbPassword = environment.getProperty("db.password");

        final JdbcPropertyService jdbcPropertyService =
                new JdbcPropertyServiceImpl(dbDriver, dbUrl, dbUsername, dbPassword);
        final DataSource propertiesDataSource =
                jdbcPropertyService.createPropertiesDataSource(jdbcSqlScripts);
        final JdbcPropertySourceImpl jdbcPropertySource = new JdbcPropertySourceImpl(propertiesDataSource,
                appEnvironment, jdbcQueryString, jdbcPropertyEntityRowMapper);
        return jdbcPropertySource;
    }
}
