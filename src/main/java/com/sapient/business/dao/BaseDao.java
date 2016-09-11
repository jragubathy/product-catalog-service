/**
 * 
 */
package com.sapient.business.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Ragubathy Jayaraju
 *
 */
public abstract class BaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
