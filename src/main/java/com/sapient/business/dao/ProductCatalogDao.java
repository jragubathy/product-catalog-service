/**
 * 
 */
package com.sapient.business.dao;

import java.util.List;

import com.sapient.business.vo.request.ProductCatalogRequest;

/**
 * @author Ragubathy Jayaraju
 *
 */
public interface ProductCatalogDao {

    /**
     * 
     * @param productCatalogRequest
     * @throws Exception
     */
    void addProduct(ProductCatalogRequest productCatalogRequest) throws Exception;

    /**
     * 
     * @param productName
     * @return
     * @throws Exception
     */
    boolean isProductExist(String productName) throws Exception;

    /**
     * 
     * @param productType
     * @return
     * @throws Exception
     */
    List<ProductCatalogRequest> getAllProducts(String productType) throws Exception;
    
    /**
     * 
     * @param productName
     * @throws Exception
     */
    void removeProduct(String productName) throws Exception;
    
    /**
     * 
     * @param productName
     * @return
     * @throws Exception
     */
    ProductCatalogRequest getProductDetails(String productName) throws Exception;

}
