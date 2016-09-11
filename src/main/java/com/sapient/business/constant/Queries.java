/**
 * 
 */
package com.sapient.business.constant;

/**
 * @author Ragubathy Jayaraju
 *
 */
public interface Queries {

    String ADD_PRODUCT_QUERY = "insert into PRODUCT_CATALOG "
            + "(product_name, product_type, product_description, created_on, created_by, updated_on, updated_by) "
            + "VALUES (?, ?, ?, NOW(), ?, NOW(), ?)";

    String PRODUCT_EXISTS = "select count(*) from PRODUCT_CATALOG where product_name = ?";

    String GET_ALL_PRODUCTS_BY_TYPE = "SELECT product_name, product_type, product_description, created_on, created_by, updated_on, updated_by"
            + " from PRODUCT_CATALOG where product_type = ?";

    String DELETE_PRODUCT = "DELETE from PRODUCT_CATALOG where product_name = ?";

    String GET_PRODUCT_BY_NAME = "SELECT product_name, product_type, product_description, created_on, created_by, updated_on, updated_by"
            + " from PRODUCT_CATALOG where product_name = ?";
}
