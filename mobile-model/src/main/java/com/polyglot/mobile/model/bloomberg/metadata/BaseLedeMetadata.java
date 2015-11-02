package com.polyglot.mobile.model.bloomberg.metadata;

import com.polyglot.mobile.model.bloomberg.common.BCaptionModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class BaseLedeMetadata implements BCaptionModel {

    private String type;
    private String size;
    private String caption;
    private String credit;

}
