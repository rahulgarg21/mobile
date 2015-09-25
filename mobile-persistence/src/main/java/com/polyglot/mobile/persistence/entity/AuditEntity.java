package com.polyglot.mobile.persistence.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Rajiv Singla on 9/24/2015.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "CREATED_BY_USER", nullable = false)
    @CreatedBy
    protected String createdByUser;

    @Column(name = "CREATION_TIME", nullable = false)
    @CreatedDate
    protected ZonedDateTime creationTime;

    @Column(name = "LAST_MODIFIED_BY_USER", nullable = false)
    @LastModifiedBy
    protected String lastModifiedByUser;

    @Column(name = "LAST_MODIFICATION_TIME", nullable = false)
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdByUser", createdByUser)
                .append("creationTime", creationTime)
                .append("lastModifiedByUser", lastModifiedByUser)
                .append("lastModificationTime", lastModificationTime)
                .append("version", version)
                .toString();
    }
}
