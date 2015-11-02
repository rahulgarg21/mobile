package com.polyglot.mobile.model.bloomberg.credits.author;

import com.polyglot.mobile.model.bloomberg.credits.BaseGenericMediaCredits;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class MediaAuthorCredits extends BaseGenericMediaCredits {

    private List<MediaAuthor> author;

}
