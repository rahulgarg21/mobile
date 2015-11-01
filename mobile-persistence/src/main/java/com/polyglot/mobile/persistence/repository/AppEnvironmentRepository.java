package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.persistence.entity.AppEnvironmentEntity;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Repository
public interface AppEnvironmentRepository extends JpaRepository<AppEnvironmentEntity, Long> {

    @Cacheable(cacheNames = "appEnvironments")
    List<AppEnvironmentEntity> findByAppEnvironmentName(AppEnvironment appEnvironment);

    @Cacheable(cacheNames = "appEnvironments", key = "#id")
    AppEnvironmentEntity findOne(Long id);

    @CachePut(cacheNames = "appEnvironments", key = "#result.id")
    AppEnvironmentEntity saveAndFlush(AppEnvironmentEntity entity);

}
