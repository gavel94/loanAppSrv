package com.hzszn.loanappsrv.orm;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDate;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@MappedTypes(Date.class)
@MappedJdbcTypes(JdbcType.DATE)
public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate>
{
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDate localDate, JdbcType jdbcType) throws SQLException
    {
        ps.setDate(i, Date.valueOf(localDate));
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, String s) throws SQLException
    {
        Date sqlDate = resultSet.getDate(s);
        return sqlDate != null ? sqlDate.toLocalDate() : null;
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, int i) throws SQLException
    {
        Date sqlDate = resultSet.getDate(i);
        return sqlDate != null ? sqlDate.toLocalDate() : null;
    }

    @Override
    public LocalDate getNullableResult(CallableStatement callableStatement, int i) throws SQLException
    {
        Date sqlDate = callableStatement.getDate(i);
        return sqlDate != null ? sqlDate.toLocalDate() : null;
    }
}
