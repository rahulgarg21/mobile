package com.polyglot.mobile.testsupport.integrationtest;

import com.polyglot.mobile.testsupport.config.MobileTestSupportConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MobileTestSupportConfig.class})
@ActiveProfiles({"DEV","integration-test"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Rollback(value = true)
public abstract class BaseMobileIntegrationTest {
}
