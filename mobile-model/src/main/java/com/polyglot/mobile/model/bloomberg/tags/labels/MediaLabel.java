package com.polyglot.mobile.model.bloomberg.tags.labels;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BNameModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class MediaLabel implements BIdModel<String>, BNameModel {

    private String id;
    private String name;
}
