package com.polyglot.mobile.model.bloomberg.common;

import java.util.List;

/**
 * Bloomberg Model which contain ordered collection
 * of other Bloomberg Models
 *
 * Created by Rajiv Singla on 10/22/2015.
 */
public interface BItemsModel<T extends BModel> extends BModel {

    public List<T> getItems();

}
