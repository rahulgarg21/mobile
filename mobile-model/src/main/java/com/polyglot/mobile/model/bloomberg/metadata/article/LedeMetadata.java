package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.common.BCaptionModel;
import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class LedeMetadata implements BIdModel<Integer>,BCaptionModel{

    private String type;
    private Integer id;
    private String size;
    private String caption;
    private String credit;

}
