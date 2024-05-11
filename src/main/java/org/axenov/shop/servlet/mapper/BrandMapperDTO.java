package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Brand;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapperDTO {
    BrandMapperDTO INSTANCE =Mappers.getMapper(BrandMapperDTO.class);

    BrandDTO toBrandDTO(Brand brand);
    Brand toBrand(BrandDTO brandDTO);

}
