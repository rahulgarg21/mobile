package com.polyglot.mobile.model.bloomberg.attachment;

import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoMediaAttachment;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class ArticleMediaAttachment  {

    private ImageMediaAttachment image;
    private VideoMediaAttachment video;

}
