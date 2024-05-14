package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Fastener;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface FastenerMapperDTO {


    FastenerDTO toFastenerDTO(Fastener fastener);

   Fastener toFastener(FastenerDTO fastenerDTO);



}
