package com.hzszn.loanappsrv.orm;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@MappedTypes(Timestamp.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime>
{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime localDateTime, JdbcType jdbcType) throws SQLException
    {
        ps.setTimestamp(i, Timestamp.valueOf(localDateTime));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet resultSet, String s) throws SQLException
    {
        Timestamp timestamp = resultSet.getTimestamp(s);
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet resultSet, int i) throws SQLException
    {
        Timestamp timestamp = resultSet.getTimestamp(i);
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException
    {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
