package com.polyglot.mobile.persistence.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.polyglot.common.TodoConstants.TODO_DESCRIPTION_MAX_LENGTH;
import static com.polyglot.common.TodoConstants.TODO_TITLE_MAX_LENGTH;

/**
 * Created by Rajiv Singla on 9/22/2015.
 */
@Entity
@Table(name = "TODOS")
public class Todo extends AuditEntity {

    @Column(name = "TITLE", nullable = false, length = TODO_TITLE_MAX_LENGTH)
    private String title;

    @Column(name = "DESCRIPTION", length = TODO_DESCRIPTION_MAX_LENGTH)
    private String description;

    /**
     * Required by hibernate
     */
    private Todo() {
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Builder create() {
        return new Builder();
    }

    private static void validateTitle(String title) {
        checkNotNull(title, "Title cannot be null");
        checkArgument(TODO_TITLE_MAX_LENGTH > title.length(), "Title cannot exceed max length: " + TODO_TITLE_MAX_LENGTH);
    }

    private static void validateDescription(String description) {
        checkArgument(description != null && TODO_DESCRIPTION_MAX_LENGTH > description.length(), "Description cannot exceed max length: " + TODO_DESCRIPTION_MAX_LENGTH);
    }

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

    @Override
    public String toString() {
        return super.toString() +
                new ToStringBuilder(this)
                        .append("title", title)
                        .append("description", description)
                        .append(super.toString())
                        .toString();
    }

    public static class Builder {

        private String title;
        private String description;

        public Builder setTitle(String title) {
            validateTitle(title);
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            validateDescription(description);
            this.description = description;
            return this;
        }

        public Todo build() {
            return new Todo(checkNotNull(title), description);
        }
    }
}
