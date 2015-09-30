package com.polyglot.mobile.persistence.entity;

import com.polyglot.mobile.persistence.common.MobileEnvironment;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Rajiv Singla on 9/22/2015.
 */
@Entity
@Table(name = "ENVIRONMENT", schema = "CONFIG")
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
public class EnvironmentEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENVIRONMENT_ID_SEQ")
    @SequenceGenerator(name = "ENVIRONMENT_ID_SEQ", sequenceName = "ENVIRONMENT_ID_SEQ", initialValue = 0, allocationSize = 50, schema = "CONFIG")
    @Column(name="ENVIRONMENT_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private MobileEnvironment name;

    @Column(name = "DESCRIPTION")
    @NonNull
    private String description;


}
