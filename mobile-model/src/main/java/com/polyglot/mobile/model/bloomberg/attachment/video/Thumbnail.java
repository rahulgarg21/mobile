package com.polyglot.mobile.model.bloomberg.attachment.video;

import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.common.BModel;
import lombok.Data;

import java.util.Map;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class Thumbnail implements BModel {

    private Map<String, Image> images;
}
