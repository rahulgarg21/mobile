package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.video;

import com.polyglot.mobile.model.bloomberg.metadata.video.VideoLedeMetadata;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.BaseGenericMediaMetadataMixin;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class VideoMetadataMixin extends BaseGenericMediaMetadataMixin {

    private VideoLedeMetadata lede;
    private String prerollAdCode;
    private List<String> prerollNiCodes;
}
