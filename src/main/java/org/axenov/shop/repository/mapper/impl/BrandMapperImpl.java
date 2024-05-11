package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.mapper.BrandMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand mapToBrand(ResultSet resultSet) {
        try{
            Brand brand = new Brand();
            brand.setNameBrand(resultSet.getString("name_brand"));
            brand.setIdBrand(resultSet.getLong("id_brand"));
            return brand;
        }
        catch (SQLException e){
            throw new IllegalArgumentException(e);
        }

    }
}
