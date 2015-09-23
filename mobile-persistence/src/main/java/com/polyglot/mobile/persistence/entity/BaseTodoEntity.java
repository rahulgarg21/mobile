package com.polyglot.mobile.persistence.entity;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Rajiv Singla on 9/22/2015.
 */
public abstract class BaseTodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="CREATED_BY_USER", nullable = false)
    @CreatedBy
    protected String createdByUser;

    @Column(name="CREATION_TIME", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @CreatedDate
    protected ZonedDateTime creationTime;

    @Column(name="LAST_MODIFIED_BY_USER", nullable = false)
    @LastModifiedBy
    protected String lastModifiedByUser;

    @Column(name="LAST_MODIFICATION_TIME", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @LastModifiedDate
    protected ZonedDateTime lastModificationTime;

    @Version
    protected long version;

    public Long getId() {
        return id;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public String getLastModifiedByUser() {
        return lastModifiedByUser;
    }

    public ZonedDateTime getLastModificationTime() {
        return lastModificationTime;
    }

    public long getVersion() {
        return version;
    }
}
