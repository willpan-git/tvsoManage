/**
 * 
 */
package com.skyworth.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;




/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MyTypeHandler.java
 * @Description: mybatis 处理空数据
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月17日 下午5:31:06
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月17日
 *        Administrator v1.0.0 修改原因
 */
@Component
public class MyTypeHandler implements TypeHandler<String> {

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
	return (rs.getString(columnName) == null) ? "" : rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
	return (rs.getString(columnIndex) == null) ? "" : rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
	return (cs.getString(columnIndex) == null) ? "" : cs.getString(columnIndex);
    }

    @Override
    public void setParameter(PreparedStatement ps, int arg1, String str, JdbcType jdbcType) throws SQLException {
    }
}
