/**
 * 
 */
package com.sapient.business.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.business.constant.AppConstant;
import com.sapient.business.exception.ProductCatalogException;
import com.sapient.business.service.ProductCatalogService;
import com.sapient.business.util.ResponseUtil;
import com.sapient.business.vo.ResponseErrorVO;
import com.sapient.business.vo.ServiceResponseVO;
import com.sapient.business.vo.request.ProductCatalogRequest;
import com.sapient.business.vo.response.ProductCatalogResponse;

/**
 * @author Ragubathy Jayaraju
 *
 */
@RestController
@RequestMapping(value = AppConstant.PRODUCT, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductCatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogController.class);

    @Autowired
    ProductCatalogService productCatalogService;

    /**
     * 
     * @param productCatalogRequest
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = AppConstant.ADD_PRODUCT, method = RequestMethod.POST)
    public HttpEntity<? extends Object> addProduct(@Valid @RequestBody ProductCatalogRequest productCatalogRequest,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {

            try {

                productCatalogService.addProduct(productCatalogRequest);

            } catch (ProductCatalogException e) {
                LOGGER.error(e.getLocalizedMessage());
                return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(false,
                        e.getLocalizedMessage(), null), HttpStatus.OK);
            } catch (Exception e) {
                LOGGER.error("The operation could not be completed ..");
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(true, "Successfully Added",
                    null), HttpStatus.OK);
        } else {

            return new ResponseEntity<ResponseErrorVO>(ResponseUtil.sendJsonErrorResponse("Validation Error",
                    bindingResult.getFieldErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * 
     * @param productType
     * @return
     */
    @RequestMapping(value = AppConstant.RETRIEVE_PRODUCTS, method = RequestMethod.GET)
    public HttpEntity<? extends Object> getAllProducts(@NotEmpty @RequestParam("productType") String productType) {

        ProductCatalogResponse productCatalogResponse = null;

        try {

            productCatalogResponse = productCatalogService.getAllProducts(productType);

        } catch (ProductCatalogException e) {
            LOGGER.error(e.getLocalizedMessage());
            return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(true, e.getLocalizedMessage(),
                    null), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("The operation could not be completed ..");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(true, "Successfull Retrieved",
                productCatalogResponse.getItems()), HttpStatus.OK);
    }

    /**
     * 
     * @param productName
     * @return
     */
    @RequestMapping(value = AppConstant.REMOVE_PRODUCT, method = RequestMethod.GET)
    public HttpEntity<? extends Object> removeProduct(@NotEmpty @RequestParam("productName") String productName) {

        try {

            productCatalogService.removeProduct(productName);

        } catch (ProductCatalogException e) {
            LOGGER.error(e.getLocalizedMessage());
            return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(false,
                    e.getLocalizedMessage(), null), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("The operation could not be completed ..");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ServiceResponseVO>(
                ResponseUtil.mapServiceResponse(true, "Successfull Deleted", null), HttpStatus.OK);
    }

    /**
     * 
     * @param productName
     * @return
     */
    @RequestMapping(value = AppConstant.GET_PRODUCT_DETAIL, method = RequestMethod.GET)
    public HttpEntity<? extends Object> getProductDetails(@NotEmpty @RequestParam("productName") String productName) {

        ProductCatalogResponse productCatalogResponse = null;

        try {

            productCatalogResponse = productCatalogService.getProductDetails(productName);

        } catch (ProductCatalogException e) {
            LOGGER.error(e.getLocalizedMessage());
            return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(false,
                    e.getLocalizedMessage(), null), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("The operation could not be completed ..");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ServiceResponseVO>(ResponseUtil.mapServiceResponse(true, "Successfull Retrieved",
                productCatalogResponse.getItems()), HttpStatus.OK);
    }
}
