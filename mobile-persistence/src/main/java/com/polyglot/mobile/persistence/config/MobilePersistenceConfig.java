package com.polyglot.mobile.persistence.config;

import com.polyglot.mobile.common.config.MobileCommonConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        "com.polyglot.mobile.persistence.repository"
})
@EnableSpringDataWebSupport
@Import(value = {MobileJpaAuditingConfig.class, MobileCommonConfig.class})
public class MobilePersistenceConfig {

    /**
     * Package location for all jpa managed entities
     */
    private static final String[] ENTITY_PACKAGES = {"com.polyglot.mobile.persistence.entity"};

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";


    @Bean(destroyMethod = "close")
    public DataSource dataSource(@Value("${db.driver}") final String dbDriver,
                                 @Value("${db.url}") final String dbUrl,
                                 @Value("${db.username}") final String dbUserName,
                                 @Value("${db.password}") final String dbPassword) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(dbDriver);
        dataSourceConfig.setJdbcUrl(dbUrl);
        dataSourceConfig.setUsername(dbUserName);
        dataSourceConfig.setPassword(dbPassword);
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
                                                                       @Value("${hibernate.dialect}") final String hibernateDialect,
                                                                       @Value("${hibernate.format_sql}") final Boolean hibernateFormatSql,
                                                                       @Value("${hibernate.hbm2ddl.auto}") final String hibernateHbm2ddl,
                                                                       @Value("${hibernate.ejb.naming_strategy}") final String hibernateNamingStrategy,
                                                                       @Value("${hibernate.show_sql}") final Boolean hibernateShowSql) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);
        final Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddl);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, hibernateNamingStrategy);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, hibernateFormatSql);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
