package com.polyglot.mobile.persistence.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rajiv Singla on 9/24/2015.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
public abstract class AuditEntity {

    @Column(name = "CREATED_BY_USER", nullable = false)
    @CreatedBy
    protected String createdByUser;

    @Column(name = "CREATION_TIME", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationTime;

    @Column(name = "LAST_MODIFIED_BY_USER", nullable = false)
    @LastModifiedBy
    protected String lastModifiedByUser;

    @Column(name = "LAST_MODIFICATION_TIME", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModificationTime;

    @Version
    protected long version;
}
