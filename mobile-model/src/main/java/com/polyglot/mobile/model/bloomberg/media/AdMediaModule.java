package com.polyglot.mobile.model.bloomberg.media;

import lombok.Data;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@Data
public class AdMediaModule implements GenericModuleMedia {

    private String id;
    private String adType;
    private String type;
    private Integer adPositionIncrement;

}
