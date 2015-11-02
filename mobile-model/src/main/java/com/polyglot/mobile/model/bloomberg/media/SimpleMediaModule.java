package com.polyglot.mobile.model.bloomberg.media;

import lombok.Data;

/**
 * Created by Rajiv Singla on 11/17/2015.
 */
@Data
public class SimpleMediaModule implements GenericModuleMedia {
    private String id;
    private String type;
}
