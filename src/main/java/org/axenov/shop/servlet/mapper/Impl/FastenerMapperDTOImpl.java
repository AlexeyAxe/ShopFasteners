package org.axenov.shop.servlet.mapper.Impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.axenov.shop.servlet.mapper.FastenerMapperDTO;

public class FastenerMapperDTOImpl implements FastenerMapperDTO {
    @Override
    public FastenerDTO toFastenerDTO(Fastener fastener) {
        FastenerDTO fastenerDTO=new FastenerDTO();
        fastenerDTO.setIdFastener(fastener.getIdFastener());
        fastenerDTO.setNameFastener(fastener.getNameFastener());
        return fastenerDTO;
    }

    @Override
    public Fastener toFastener(FastenerDTO fastenerDTO) {
        Fastener fastener=new Fastener();
        fastener.setIdFastener(fastenerDTO.getIdFastener());
        fastener.setNameFastener(fastenerDTO.getNameFastener());
        return fastener;
    }
}
