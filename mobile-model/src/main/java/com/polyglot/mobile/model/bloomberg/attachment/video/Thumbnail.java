package com.polyglot.mobile.model.bloomberg.attachment.video;

import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import lombok.Data;

import java.util.Map;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class Thumbnail {

    private Map<String, Image> images;
}
