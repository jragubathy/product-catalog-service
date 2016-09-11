/**
 * 
 */
package com.sapient.business.util;

import java.util.Collection;

import com.sapient.business.vo.ResponseErrorVO;
import com.sapient.business.vo.ServiceResponseVO;

/**
 * @author Ragubathy Jayaraju
 *
 */
public class ResponseUtil {

    public static ResponseErrorVO sendJsonErrorResponse(String errorCode, String errorMessage) {
        ResponseErrorVO errorVo = new ResponseErrorVO(errorCode, errorMessage);
        return errorVo;
    }

    public static ServiceResponseVO mapServiceResponse(boolean transactionStatus, String message, Collection<?> items) {
        ServiceResponseVO serviceResponseVO = new ServiceResponseVO(transactionStatus, message, items);
        return serviceResponseVO;
    }

}
