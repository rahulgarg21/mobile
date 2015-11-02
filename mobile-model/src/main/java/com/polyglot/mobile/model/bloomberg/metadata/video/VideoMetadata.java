package com.polyglot.mobile.model.bloomberg.metadata.video;

import com.polyglot.mobile.model.bloomberg.metadata.BaseGenericMediaMetadata;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class VideoMetadata extends BaseGenericMediaMetadata {

    private VideoLedeMetadata lede;
    private String prerollAdCode;
    private List<String> prerollNiCodes;

}
