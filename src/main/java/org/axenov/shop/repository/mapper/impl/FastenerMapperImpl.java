package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.mapper.FastenerMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FastenerMapperImpl implements FastenerMapper {
    @Override
    public Fastener mapToFastener(ResultSet resultSet) {
        try {
            Fastener fastener =new Fastener();
            fastener.setIdFastener(resultSet.getLong("id_fastener"));
            fastener.setNameFastener(resultSet.getString("name_fastener"));
            return fastener;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
