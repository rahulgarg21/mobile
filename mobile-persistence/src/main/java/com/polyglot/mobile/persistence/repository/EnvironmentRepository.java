package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.persistence.common.MobileEnvironment;
import com.polyglot.mobile.persistence.entity.EnvironmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Repository
public interface EnvironmentRepository extends CrudRepository<EnvironmentEntity, Long> {

    List<EnvironmentEntity> findByName(MobileEnvironment mobileEnvironment);

}
