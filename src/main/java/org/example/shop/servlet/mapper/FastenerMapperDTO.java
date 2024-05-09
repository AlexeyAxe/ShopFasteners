package org.example.shop.servlet.mapper;

import org.example.shop.model.Fastener;
import org.example.shop.servlet.dto.FastenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FastenerMapperDTO {

    FastenerMapperDTO INSTANCE = Mappers.getMapper(FastenerMapperDTO.class);

    FastenerDTO toFastenerDTO(Fastener fastener);
    Fastener toFastener(FastenerDTO fastenerDTO);

}
