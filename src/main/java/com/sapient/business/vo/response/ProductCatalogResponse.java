/**
 * 
 */
package com.sapient.business.vo.response;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ragubathy Jayaraju
 *
 */
public class ProductCatalogResponse {

    @JsonProperty
    private Collection<?> items;

    /**
     * @return the items
     */
    public Collection<?> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(Collection<?> items) {
        this.items = items;
    }

}
