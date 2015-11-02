package com.polyglot.mobile.model.bloomberg.tags;

import com.polyglot.mobile.model.bloomberg.tags.labels.MediaLabel;
import com.polyglot.mobile.model.bloomberg.tags.topics.MediaTopic;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class BaseGenericMediaTags implements GenericMediaTags {

    private List<MediaTopic> topics;
    private List<MediaLabel> labels;

}
