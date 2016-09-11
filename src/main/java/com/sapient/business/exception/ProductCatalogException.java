/**
 * 
 */
package com.sapient.business.exception;

/**
 * @author Ragubathy Jayaraju
 *
 */
public class ProductCatalogException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ProductCatalogException(String message) {
        super(message);
    }

    public ProductCatalogException(Throwable originalException) {
        super(originalException);
    }

    public ProductCatalogException(String message, Throwable originalException) {
        super(message, originalException);
    }

}
