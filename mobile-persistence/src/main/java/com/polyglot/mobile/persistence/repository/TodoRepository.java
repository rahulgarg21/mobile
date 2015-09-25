package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.persistence.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByTitle(String title);

}
