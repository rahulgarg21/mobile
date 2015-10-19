package com.polyglot.mobile.common.util.spring.impl;

import com.google.common.base.Preconditions;
import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.common.exception.InvalidAppEnvironmentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rajiv Singla on 10/7/2015.
 */
@Slf4j
public class JdbcPropertyEntityRowMapper implements RowMapper<JdbcPropertyEntity> {
    @Override
    public JdbcPropertyEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final String appEnvironmentName = rs.getString("APP_ENVIRONMENT_NAME");
        final AppEnvironment appEnvironment = AppEnvironment.appEnvironmentNameMap.get(appEnvironmentName);
        final String propertyName = rs.getString("APP_PROPERTY_KEY");
        final String propertyValue = rs.getString("APP_PROPERTY_VALUE");

        if(appEnvironment == null) {
            String errorMessage = "Unable to find App Environments with database returned App Environment Name string: " + appEnvironmentName;
            log.error(errorMessage);
            throw new InvalidAppEnvironmentException(errorMessage);
        }

        Preconditions.checkNotNull(propertyName, "Database Property Name must not be null");
        Preconditions.checkNotNull(propertyValue, "Database Property Value must not be null");

        return JdbcPropertyEntity.builder()
                .appEnvironment(appEnvironment)
                .propertyKey(propertyName)
                .propertyValue(propertyValue)
                .build();
    }
}
