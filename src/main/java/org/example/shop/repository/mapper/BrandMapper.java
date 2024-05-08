package org.example.shop.repository.mapper;

import org.example.shop.model.Brand;

import java.sql.ResultSet;

public interface BrandMapper {
    Brand mapToBrand(ResultSet resultSet);
}
