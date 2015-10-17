package com.polyglot.mobile.common.common;

import com.polyglot.mobile.common.config.MobileCommonTestConfig;
import com.polyglot.mobile.testsupport.integrationtest.BaseMobileIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */

@ContextConfiguration(classes = {MobileCommonTestConfig.class})
public abstract class BaseMobileCommonIT extends BaseMobileIntegrationTest {
}
