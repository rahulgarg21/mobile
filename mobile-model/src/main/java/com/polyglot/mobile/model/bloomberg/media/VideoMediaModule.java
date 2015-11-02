package com.polyglot.mobile.model.bloomberg.media;

import com.polyglot.mobile.model.bloomberg.metadata.video.VideoMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class VideoMediaModule extends BaseArticleMediaModule {

    protected VideoMetadata metadata;

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.VIDEO.getDescription()));
        return ModuleMediaType.VIDEO;
    }

}
