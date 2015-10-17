package com.polyglot.mobile.common.util.spring.impl;

import com.polyglot.mobile.common.util.spring.JdbcPropertyService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.Driver;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
public class JdbcPropertyServiceImpl implements JdbcPropertyService {

    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public JdbcPropertyServiceImpl(@NotNull final String driverClassName,
                                   @NotNull final String url,
                                   @NotNull final String username,
                                   @NotNull final String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public DataSource createPropertiesDataSource(final String... sqlScriptPaths) {
        final Driver driver;
        try {
            Class<?> driverClass = this.getClass().getClassLoader().loadClass(driverClassName);
            driver = (Driver) driverClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not load class of driverClassName " + driverClassName, e);
        }
        final SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource(driver, url, username, password);

        if(sqlScriptPaths != null) {
            executePropertySqlScript(simpleDriverDataSource,sqlScriptPaths);
        }
        return simpleDriverDataSource;
    }

    private void executePropertySqlScript(final DataSource targetDataSource, final String... sqlScriptPaths) {
        final ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(false);
        for(String sqlScriptPath : sqlScriptPaths) {
            databasePopulator.addScript(new ClassPathResource(sqlScriptPath));
        }
        DatabasePopulatorUtils.execute(databasePopulator, targetDataSource);
    }
}
