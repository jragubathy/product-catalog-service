/**
 * 
 */
package com.sapient.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.business.dao.ProductCatalogDao;
import com.sapient.business.exception.ProductCatalogException;
import com.sapient.business.service.ProductCatalogService;
import com.sapient.business.vo.request.ProductCatalogRequest;
import com.sapient.business.vo.response.ProductCatalogResponse;

/**
 * @author Ragubathy Jayaraju
 *
 */
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogServiceImpl.class);

    @Autowired
    private ProductCatalogDao productCatalogDao;

    /**
     * 
     * @param productCatalogRequest
     * @throws ProductCatalogException
     * @throws Exception
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addProduct(ProductCatalogRequest productCatalogRequest) throws ProductCatalogException, Exception {

        try {

            if (!isProductExist(productCatalogRequest.getProductName())) {
                productCatalogDao.addProduct(productCatalogRequest);
            } else {
                throw new ProductCatalogException("Product Already Exists");
            }

        } catch (ProductCatalogException pce) {
            LOGGER.error(pce.getLocalizedMessage(), pce);
            throw pce;
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
    private boolean isProductExist(String productName) throws Exception {

        try {

            return productCatalogDao.isProductExist(productName);

        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * 
     * @param productType
     * @return
     * @throws Exception
     */
    public ProductCatalogResponse getAllProducts(String productType) throws Exception {

        ProductCatalogResponse productCatalogResponse = new ProductCatalogResponse();

        try {

            List<ProductCatalogRequest> list = productCatalogDao.getAllProducts(productType);
            if (list.size() > 0) {
                productCatalogResponse.setItems(list);
            } else {
                throw new ProductCatalogException("Products Not Found for given product type.");
            }

        } catch (ProductCatalogException pce) {
            LOGGER.error(pce.getLocalizedMessage(), pce);
            throw pce;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }

        return productCatalogResponse;
    }

    /**
     * 
     * @param productName
     * @throws ProductCatalogException
     * @throws Exception
     */
    public void removeProduct(String productName) throws ProductCatalogException, Exception {

        try {

            if (isProductExist(productName)) {
                productCatalogDao.removeProduct(productName);
            } else {
                throw new ProductCatalogException("Product NOT found for deletion");
            }
        } catch (ProductCatalogException pce) {
            LOGGER.error(pce.getLocalizedMessage(), pce);
            throw pce;
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
    public ProductCatalogResponse getProductDetails(String productName) throws Exception {

        ProductCatalogResponse productCatalogResponse = new ProductCatalogResponse();

        try {

            ProductCatalogRequest productCatalogRequest = productCatalogDao.getProductDetails(productName);
            if (productCatalogRequest != null) {
                List<ProductCatalogRequest> productCatalogRequestList = new ArrayList<ProductCatalogRequest>();
                productCatalogRequestList.add(productCatalogRequest);
                productCatalogResponse.setItems(productCatalogRequestList);
            } else {
                throw new ProductCatalogException("Products Not Found for given product name.");
            }
        } catch (ProductCatalogException pce) {
            LOGGER.error(pce.getLocalizedMessage(), pce);
            throw pce;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e);
            throw e;
        }

        return productCatalogResponse;
    }
}
