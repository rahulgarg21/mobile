package com.polyglot.mobile.persistence.repository;

import com.google.common.collect.Sets;
import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.persistence.common.BaseMobilePersistenceIT;
import com.polyglot.mobile.persistence.entity.AppEnvironmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Slf4j
public class AppEnvironmentRepositoryIT extends BaseMobilePersistenceIT {

    @Resource
    private AppEnvironmentRepository appEnvironmentRepository;

    @Resource
    private CacheManager cacheManager;

    @Test
    public void testFindAll() throws Exception {

        Iterable<AppEnvironmentEntity> appEnvironmentEntities = appEnvironmentRepository.findAll();
        Assert.assertThat("At least one environment must be configured in app Environment Table",
                Sets.newHashSet(appEnvironmentEntities).size(),
                greaterThan(1));
    }

    @Test
    public void testFindByAppEnvironmentName() throws Exception {
        final List<AppEnvironmentEntity> byAppEnvironmentName =
                appEnvironmentRepository.findByAppEnvironmentName(AppEnvironment.COMMON);
        log.debug(byAppEnvironmentName.toString());
    }


}