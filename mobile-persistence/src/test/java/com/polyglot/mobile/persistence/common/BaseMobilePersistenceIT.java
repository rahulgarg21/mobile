package com.polyglot.mobile.persistence.common;

import com.polyglot.mobile.persistence.config.MobilePersistenceTestConfig;
import com.polyglot.mobile.testsupport.integrationtest.BaseMobileIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@ContextConfiguration(classes = {MobilePersistenceTestConfig.class})
public abstract class BaseMobilePersistenceIT extends BaseMobileIntegrationTest {
}
