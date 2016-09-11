/**
 * 
 */
package com.sapient.business.service;

import com.sapient.business.exception.ProductCatalogException;
import com.sapient.business.vo.request.ProductCatalogRequest;
import com.sapient.business.vo.response.ProductCatalogResponse;

/**
 * @author Ragubathy Jayaraju
 *
 */
public interface ProductCatalogService {

    /**
     * 
     * @param productCatalogRequest
     * @throws ProductCatalogException
     * @throws Exception
     */
    void addProduct(ProductCatalogRequest productCatalogRequest) throws ProductCatalogException, Exception;
    
    /**
     * 
     * @param productType
     * @return
     * @throws Exception
     */
    ProductCatalogResponse getAllProducts(String productType) throws Exception;
    
    /**
     * 
     * @param productName
     * @throws ProductCatalogException
     * @throws Exception
     */
    void removeProduct(String productName) throws ProductCatalogException, Exception;
    
    /**
     * 
     * @param productName
     * @return
     * @throws Exception
     */
    ProductCatalogResponse getProductDetails(String productName) throws Exception;

}
