package com.polyglot.mobile.persistence.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Rajiv Singla on 10/4/2015.
 */

@Entity
@Table(name = "APP_PROPERTIES", schema = "CONFIG")
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = false)
public class AppPropertiesEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " APP_PROPERTIES_ID_SEQ_GEN")
    @SequenceGenerator(name = " APP_PROPERTIES_ID_SEQ_GEN", sequenceName = " APP_PROPERTIES_ID_SEQ", initialValue = 0,allocationSize = 1, schema = "CONFIG")
    @Column(name="APP_PROPERTIES_ID")
    private Long id;

    @Column(name = "APP_PROPERTY_KEY", nullable = false)
    @NonNull
    private String appPropertyKey;

    @Column(name = "APP_PROPERTY_VALUE", nullable = false)
    @NonNull
    @Lob
    private String appPropertyValue;

}
