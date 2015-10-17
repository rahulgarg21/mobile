package com.polyglot.mobile.common.util.ehcache;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListenerAdapter;

/**
 * Created by Rajiv Singla on 10/4/2015.
 */
@Slf4j
public class EhCacheExpiryListener extends CacheEventListenerAdapter {

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        log.debug("Ehache Expired Event. Cache Name: {}, Element: {}, Last AccessTime: {}", cache.getName(), element.getObjectKey().toString(), element.getLastAccessTime());
    }
}
