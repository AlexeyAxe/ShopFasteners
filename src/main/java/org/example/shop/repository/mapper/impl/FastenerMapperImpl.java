package org.example.shop.repository.mapper.impl;



import org.example.shop.model.Brand;
import org.example.shop.model.Fastener;
import org.example.shop.repository.mapper.FastenerMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FastenerMapperImpl implements FastenerMapper {
    @Override
    public Fastener mapToFastener(ResultSet resultSet) {
        try {
            Fastener fastener =new Fastener();
            fastener.setIdFastener(Long.parseLong(resultSet.getString("id_fastener")));
            fastener.setNameFastener(resultSet.getString("name_fastener"));
            return fastener;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
