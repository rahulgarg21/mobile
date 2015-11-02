package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BTypeModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/12/2015.
 */
@Data
public class AllAttachementsAddValuesMetadata implements BIdModel<String>, BTypeModel {

    private String id;
    private String type;
    private List<String> placement;

}
