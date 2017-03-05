package com.hzszn.loanappsrv.orm;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalTime;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@MappedTypes(LocalTime.class)
@MappedJdbcTypes(JdbcType.TIME)
public class LocalTimeTypeHandler extends BaseTypeHandler<LocalTime>
{
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalTime localTime, JdbcType jdbcType) throws SQLException
    {
        ps.setTime(i, Time.valueOf(localTime));
    }

    @Override
    public LocalTime getNullableResult(ResultSet resultSet, String s) throws SQLException
    {
        Time sqlTime = resultSet.getTime(s);
        return sqlTime != null ? sqlTime.toLocalTime() : null;
    }

    @Override
    public LocalTime getNullableResult(ResultSet resultSet, int i) throws SQLException
    {
        Time sqlTime = resultSet.getTime(i);
        return sqlTime != null ? sqlTime.toLocalTime() : null;
    }

    @Override
    public LocalTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException
    {
        Time sqlTime = callableStatement.getTime(i);
        return sqlTime != null ? sqlTime.toLocalTime() : null;
    }
}