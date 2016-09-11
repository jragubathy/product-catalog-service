/**
 * 
 */
package com.sapient.business.controller;

import static com.sapient.business.constant.AppConstant.HEALTHCHECK;
import static com.sapient.business.constant.AppConstant.URL_INFO;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ragubathy Jayaraju
 *
 */
@RestController
@RequestMapping(value = HEALTHCHECK)
public class HealthCheckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckController.class);

    private final Properties serviceInfo = new Properties();

    @RequestMapping(value = URL_INFO, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Properties getServiceInfo() {
        try {

            if (serviceInfo.size() < 1) {
                serviceInfo.put("service", "product-catalog-service");
                serviceInfo.put("status", HttpStatus.OK.value());
            }

        } catch (final Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return serviceInfo;
    }

}
