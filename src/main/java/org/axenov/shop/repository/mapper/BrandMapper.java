package org.axenov.shop.repository.mapper;

import org.axenov.shop.model.Brand;

import java.sql.ResultSet;

public interface BrandMapper {
    Brand mapToBrand(ResultSet resultSet);
}
