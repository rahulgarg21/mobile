package com.polyglot.mobile.persistence.entity;

import com.polyglot.mobile.common.AppEnvironment;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Rajiv Singla on 9/22/2015.
 */
@Entity
@Table(name = "APP_ENVIRONMENT", schema = "CONFIG")
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = false)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "appEnvironments")
public class AppEnvironmentEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ENVIRONMENT_ID_SEQ_GEN")
    @SequenceGenerator(name = "APP_ENVIRONMENT_ID_SEQ_GEN", sequenceName = "APP_ENVIRONMENT_ID_SEQ", initialValue = 0, allocationSize = 1, schema = "CONFIG")
    @Column(name="APP_ENVIRONMENT_ID")
    private Long id;

    @Column(name = "APP_ENVIRONMENT_NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private AppEnvironment appEnvironmentName;

    @Column(name = "APP_ENVIRONMENT_DESCRIPTION")
    @NonNull
    private String appEnvironmentDescription;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "APP_ENVIRONMENT_ID")
    private Set<AppPropertiesEntity> appPropertiesEntities;


}
