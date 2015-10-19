package com.polyglot.mobile.war.initializer;

import com.polyglot.mobile.war.config.MobileWarConfig;
import com.polyglot.mobile.war.config.MobileWarServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Rajiv Singla on 10/17/2015.
 */
public class MobileWarApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {MobileWarConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {MobileWarServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/",};
    }
}
