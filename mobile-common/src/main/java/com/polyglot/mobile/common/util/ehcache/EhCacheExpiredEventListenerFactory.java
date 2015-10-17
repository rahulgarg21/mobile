package com.polyglot.mobile.common.util.ehcache;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * Created by Rajiv Singla on 10/4/2015.
 */
public class EhCacheExpiredEventListenerFactory extends CacheEventListenerFactory {
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new EhCacheExpiryListener();
    }
}
