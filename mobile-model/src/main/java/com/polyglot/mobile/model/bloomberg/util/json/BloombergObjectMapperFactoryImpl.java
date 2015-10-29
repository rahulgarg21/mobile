package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMixin;

/**
 * Factory class to be used by clients to get Object Mapper which
 * specializes in Bloomberg Object Mapper
 * Created by Rajiv Singla on 10/28/2015.
 */
public class BloombergObjectMapperFactoryImpl implements BloombergObjectMapperFactory {


    /**
     * <p>Returns a pre configured jackson {@link ObjectMapper}
     * with all registerd generic mixins that can be used to
     * deserialize bloomberg streams properly.</p>
     *
     * <p>
     *     Client should be using this object mapper rather than
     * creating new {@link ObjectMapper} which may not have all
     * registered mixins or correct deserialization settings </p>
     *
     * @return properly configured Bloomberg object Mapper
     */
    @Override
    public ObjectMapper getGenericObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        //We don't want to deserialize every property field value
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //Image Mixins
        objectMapper.registerModule(new BloombergModule());

        return objectMapper;
    }

}
