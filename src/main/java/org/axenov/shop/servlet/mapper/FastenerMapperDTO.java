package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Fastener;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FastenerMapperDTO {

    FastenerMapperDTO INSTANCE = Mappers.getMapper(FastenerMapperDTO.class);

    FastenerDTO toFastenerDTO(Fastener fastener);
    Fastener toFastener(FastenerDTO fastenerDTO);

}
