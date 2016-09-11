/**
 * 
 */
package com.sapient.business.vo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ragubathy Jayaraju
 *
 */
@JsonRootName(value = "product")
@JsonInclude(Include.NON_NULL)
public class ProductCatalogRequest {

    @JsonProperty
    @NotNull(message = "productName is mandatory")
    @Size(min = 2, max = 40, message = "productName should be between 2 - 40 characters.")
    private String productName;

    @JsonProperty
    @NotNull(message = "productType is mandatory")
    @Size(min = 2, max = 40, message = "productType should be between 2 - 40 characters.")
    private String productType;

    @JsonProperty
    @NotNull(message = "productDescription is mandatory")
    @Size(min = 2, max = 100, message = "productDescription should be between 2 - 100 characters.")
    private String productDescription;

    @JsonProperty
    @NotNull(message = "createdBy is mandatory")
    @Size(min = 2, max = 40, message = "createdBy should be between 2 - 40 characters.")
    private String createdBy;

    @JsonProperty
    private String createdOn;

    @JsonProperty
    @NotNull(message = "modifiedBy is mandatory")
    @Size(min = 2, max = 40, message = "modifiedBy should be between 2 - 40 characters.")
    private String modifiedBy;

    @JsonProperty
    private String modifiedOn;

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     *            the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription
     *            the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     *            the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the createdOn
     */
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the modifiedOn
     */
    public String getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param modifiedOn
     *            the modifiedOn to set
     */
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
