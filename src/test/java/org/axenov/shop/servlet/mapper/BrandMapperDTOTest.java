package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Brand;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BrandMapperDTOTest {
    @InjectMocks
    private BrandMapperDTO brandMapperDTO;

    @Test
     void testToBrandDTO() {
        Brand brand = new Brand();
        brand.setNameBrand("Test Brand");
        brand.setIdBrand(1L);

        BrandDTO brandDTO = brandMapperDTO.toBrandDTO(brand);

        assertEquals(brand.getNameBrand(), brandDTO.getNameBrand());
        assertEquals(brand.getIdBrand(), brandDTO.getIdBrand());
    }

    @Test
    void testToBrand() {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setNameBrand("Test Brand");
        brandDTO.setIdBrand(1L);

        Brand brand = brandMapperDTO.toBrand(brandDTO);

        assertEquals(brandDTO.getNameBrand(), brand.getNameBrand());
        assertEquals(brandDTO.getIdBrand(), brand.getIdBrand());
    }
}