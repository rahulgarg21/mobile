package com.polyglot.mobile.common.util.spring;

import javax.sql.DataSource;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
public interface JdbcPropertyService {

    /**
     * Creates properties Data source and populates it given sql scripts
     * @param sqlScriptPaths
     * @return
     */
    public DataSource createPropertiesDataSource(final String... sqlScriptPaths);

}
