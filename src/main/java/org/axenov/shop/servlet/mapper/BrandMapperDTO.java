package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Brand;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface BrandMapperDTO {

    BrandDTO toBrandDTO(Brand brand);
    Brand toBrand(BrandDTO brandDTO);
//    BrandMapperDTO INSTANCE =Mappers.getMapper(BrandMapperDTO.class);
//
//    @Mapping(target = "idBrand", source = "idBrand")
//    @Mapping(target = "nameBrand", source = "nameBrand")
//    BrandDTO toBrandDTO(Brand brand);
//
//    @Mapping(target = "idBrand", source = "idBrand")
//    @Mapping(target = "nameBrand", source = "nameBrand")
//    Brand toBrand(BrandDTO brandDTO);

}
