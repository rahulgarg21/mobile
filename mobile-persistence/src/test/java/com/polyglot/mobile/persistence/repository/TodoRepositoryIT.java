package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.persistence.common.BaseMobilePersistenceIT;
import com.polyglot.mobile.persistence.entity.Todo;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
public class TodoRepositoryIT extends BaseMobilePersistenceIT {

    @Resource
    private TodoRepository todoRepository;

    @Test
    public void testFindByTitle() throws Exception {

        String testTitle = "TestTitle";
        String testDescription = "TestDescription";

        Todo todo = Todo.create().setTitle(testTitle).setDescription(testDescription).build();

        long existingTodos = todoRepository.count();
        Todo savedEntity = todoRepository.save(todo);
        List<Todo> todos = todoRepository.findByTitle(testTitle);

        System.out.println(todos);
    }
}