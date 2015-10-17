package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.common.AppEnvironment;
import com.polyglot.mobile.persistence.entity.AppEnvironmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Repository
public interface AppEnvironmentRepository extends CrudRepository<AppEnvironmentEntity, Long> {

    List<AppEnvironmentEntity> findByAppEnvironmentName(AppEnvironment appEnvironment);

}
