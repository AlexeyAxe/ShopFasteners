package org.example.shop.servlet.mapper;

import org.example.shop.model.Brand;
import org.example.shop.servlet.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE =Mappers.getMapper(BrandMapper.class);
    BrandDTO toDTO(Brand brand);
}
