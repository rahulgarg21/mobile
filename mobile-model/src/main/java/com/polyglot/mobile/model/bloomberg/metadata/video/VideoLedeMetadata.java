package com.polyglot.mobile.model.bloomberg.metadata.video;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.metadata.BaseLedeMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class VideoLedeMetadata extends BaseLedeMetadata implements BIdModel<String> {

    private String id;
    private String thumbnail;
    private Boolean autoplay;

}
