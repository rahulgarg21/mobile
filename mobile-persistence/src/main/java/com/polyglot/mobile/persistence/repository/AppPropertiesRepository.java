package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.persistence.entity.AppPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Rajiv Singla on 10/18/2015.
 */
public interface AppPropertiesRepository extends JpaRepository<AppPropertiesEntity, Long> {
}
