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
            if(resultSet.next()){
            fastener.setNameFastener(resultSet.getString("name_fastener"));
            fastener.setIdFastener(resultSet.getLong("id_fastener"));
            }
            return fastener;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
