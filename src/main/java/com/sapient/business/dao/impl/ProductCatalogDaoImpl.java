/**
 * 
 */
package com.sapient.business.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.sapient.business.constant.Queries;
import com.sapient.business.dao.BaseDao;
import com.sapient.business.dao.ProductCatalogDao;
import com.sapient.business.vo.request.ProductCatalogRequest;

/**
 * @author Ragubathy Jayaraju
 *
 */
@Repository
public class ProductCatalogDaoImpl extends BaseDao implements ProductCatalogDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogDaoImpl.class);

    /**
     * 
     * @param productCatalogRequest
     * @throws Exception
     */
    public void addProduct(ProductCatalogRequest productCatalogRequest) throws Exception {

        try {
            int status = jdbcTemplate.update(Queries.ADD_PRODUCT_QUERY, productCatalogRequest.getProductName(),
                    productCatalogRequest.getProductType(), productCatalogRequest.getProductDescription(),
                    productCatalogRequest.getCreatedBy(), productCatalogRequest.getModifiedBy());
            LOGGER.info("No. of records inserted : " + status);
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }
    }

    /**
     * 
     * @param productName
     * @return
     * @throws Exception
     */
    public boolean isProductExist(String productName) throws Exception {

        try {
            Integer list = jdbcTemplate.queryForObject(Queries.PRODUCT_EXISTS, Integer.class, productName);
            if (list > 0) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }
        return false;
    }

    /**
     * 
     * @param productType
     * @return
     * @throws Exception
     */
    public List<ProductCatalogRequest> getAllProducts(String productTypeValue) throws Exception {

        List<ProductCatalogRequest> productCatalogList = new ArrayList<ProductCatalogRequest>();
        ProductCatalogRequest productCatalogRequest = null;
        SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(Queries.GET_ALL_PRODUCTS_BY_TYPE, productTypeValue);
            while (results.next()) {
                productCatalogRequest = new ProductCatalogRequest();
                productCatalogRequest.setProductName(results.getString("product_name"));
                productCatalogRequest.setProductType(results.getString("product_type"));
                productCatalogRequest.setProductDescription(results.getString("product_description"));
                productCatalogRequest.setCreatedBy(results.getString("created_by"));
                productCatalogRequest.setCreatedOn(sfd.format(results.getTimestamp("created_on")));
                productCatalogRequest.setModifiedBy(results.getString("updated_by"));
                productCatalogRequest.setModifiedOn(sfd.format(results.getTimestamp("updated_on")));
                productCatalogList.add(productCatalogRequest);
            }
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }
        return productCatalogList;
    }

    /**
     * 
     * @param productName
     * @throws Exception
     */
    public void removeProduct(String productName) throws Exception {

        try {
            jdbcTemplate.update(Queries.DELETE_PRODUCT, productName);
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }
    }

    /**
     * 
     * @param productName
     * @return
     * @throws Exception
     */
    public ProductCatalogRequest getProductDetails(String productName) throws Exception {

        ProductCatalogRequest productCatalogRequest = null;

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(Queries.GET_PRODUCT_BY_NAME, productName);
            while (results.next()) {
                productCatalogRequest = new ProductCatalogRequest();
                productCatalogRequest.setProductName(results.getString("product_name"));
                productCatalogRequest.setProductType(results.getString("product_type"));
                productCatalogRequest.setProductDescription(results.getString("product_description"));
            }
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }
        return productCatalogRequest;
    }

}
