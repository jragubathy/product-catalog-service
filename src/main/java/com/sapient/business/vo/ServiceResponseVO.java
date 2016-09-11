/**
 * 
 */
package com.sapient.business.vo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Ragubathy Jayaraju
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "success", "message", "items" })
public class ServiceResponseVO {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("items")
    private Collection<?> items;

    @JsonProperty("status")
    private String overallStatus;

    public ServiceResponseVO(boolean success, String message, Collection<?> items) {
        super();
        this.success = success;
        this.message = message;
        this.items = items;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<?> getItems() {
        return items;
    }

    public void setItems(Collection<?> items) {
        this.items = items;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

}
