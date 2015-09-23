package com.polyglot.mobile.persistence.entity;

import com.google.common.base.Preconditions;
import com.polyglot.common.TodoConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.polyglot.common.TodoConstants.*;
import static com.polyglot.common.TodoConstants.TODO_DESCRIPTION_MAX_LENGTH;
import static com.polyglot.common.TodoConstants.TODO_TITLE_MAX_LENGTH;

/**
 * Created by Rajiv Singla on 9/22/2015.
 */
@Entity
@Table(name="TODOS")
public class Todo extends BaseTodoEntity {

    @Column(name="TITLE", nullable = false, length = TODO_TITLE_MAX_LENGTH)
    private String title;

    @Column(name = "DESCRIPTION", length = TODO_DESCRIPTION_MAX_LENGTH)
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void update(String title, String description) {
        validateTitle(title);
        validateDescription(description);
        this.title = title;
        this.description = description;
    }

    /**
     * Required by hibernate
     */
    private Todo() {
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static class Builder {

        private String title;
        private String description;

        public Builder(String title) {
            validateTitle(title);
            this.title = title;
        }
        public Builder setDescription(String description) {
            validateDescription(description);
            this.description = description;
            return this;
        }
        public Todo create() {
            return new Todo(title, description);
        }
    }

    private static void validateTitle(String title) {
        checkNotNull(title, "Title cannot be null");
        checkArgument(title.length() > TODO_TITLE_MAX_LENGTH, "Title cannot exceed max length: " + TODO_TITLE_MAX_LENGTH );
    }

    private static void validateDescription(String description) {
        checkArgument(description != null && description.length() > TODO_DESCRIPTION_MAX_LENGTH, "Description cannot exceed max length: " + TODO_DESCRIPTION_MAX_LENGTH);
    }
}
