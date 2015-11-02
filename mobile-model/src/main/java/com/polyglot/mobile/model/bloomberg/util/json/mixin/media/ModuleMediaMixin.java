package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.polyglot.mobile.model.bloomberg.media.*;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type",
        defaultImpl = SimpleMediaModule.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdMediaModule.class, name = "ad"),
        @JsonSubTypes.Type(value = ArticleMediaModule.class, name = "article"),
        @JsonSubTypes.Type(value = FeatureMediaModule.class, name = "feature"),
        @JsonSubTypes.Type(value = TrackerMediaModule.class, name = "tracker"),
        @JsonSubTypes.Type(value = TrackerToutMediaModule.class, name = "trackerTout"),
        @JsonSubTypes.Type(value = VideoMediaModule.class, name = "video")
})
public abstract class ModuleMediaMixin {
}
