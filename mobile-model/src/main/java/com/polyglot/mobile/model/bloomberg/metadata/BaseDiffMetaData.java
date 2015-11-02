package com.polyglot.mobile.model.bloomberg.metadata;

import lombok.Data;

/**
 * Created by Rajiv Singla on 11/12/2015.
 */
@Data
public abstract class BaseDiffMetaData implements DiffMetaData {

    protected String field;

}
