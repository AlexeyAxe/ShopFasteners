package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Brand;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.mapper.FastenerMapper;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.axenov.shop.servlet.mapper.Impl.BrandMapperDTOImpl;
import org.axenov.shop.servlet.mapper.Impl.FastenerMapperDTOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastenerMapperDTOTest {

    @Test
    void testToFastenerDTO() {
        Fastener fastener= new Fastener(1L,"тест", null);

        FastenerMapperDTO dtoMapper = new FastenerMapperDTOImpl();

        Assertions.assertEquals(fastener.getIdFastener(), dtoMapper.toFastenerDTO(fastener).getIdFastener());
        Assertions.assertEquals(fastener.getNameFastener(), dtoMapper.toFastenerDTO(fastener).getNameFastener());
    }

    @Test
    void testToFastener() {
        FastenerDTO fastenerDTO = new FastenerDTO(1L, "Apple",null);
        FastenerMapperDTO fastenerMapperDTO=new FastenerMapperDTOImpl();
        Fastener brand = fastenerMapperDTO.toFastener(fastenerDTO);

        assertEquals(fastenerDTO.getIdFastener(), brand.getIdFastener());
        assertEquals( fastenerDTO.getNameFastener(), brand.getNameFastener());
        assertEquals(fastenerDTO.getBrandList(), brand.getBrandList());
    }


}