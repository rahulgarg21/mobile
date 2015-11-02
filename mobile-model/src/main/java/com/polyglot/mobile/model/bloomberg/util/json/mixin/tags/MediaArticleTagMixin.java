package com.polyglot.mobile.model.bloomberg.util.json.mixin.tags;

import com.polyglot.mobile.model.bloomberg.tags.labels.MediaLabel;
import com.polyglot.mobile.model.bloomberg.tags.topics.MediaTopic;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class MediaArticleTagMixin {

    private List<MediaTopic> topics;
    private List<MediaLabel> labels;

}
