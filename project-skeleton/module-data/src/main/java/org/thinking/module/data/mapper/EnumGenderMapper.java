package org.thinking.module.data.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.thinking.module.domain.Person.Gender;

public class EnumGenderMapper extends BaseTypeHandler<Gender>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender gender,
                                    JdbcType jdbcType) throws SQLException {
        ps.setInt(i, gender.getValue());
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        final int gender =  rs.getInt(columnName);
        return Gender.value(gender);
    }

    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        final int gender =  rs.getInt(columnIndex);
        return Gender.value(gender);
    }

    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Gender.value(cs.getInt(columnIndex));
    }

}
