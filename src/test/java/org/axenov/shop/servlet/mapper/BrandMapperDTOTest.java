package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Brand;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.mapper.BrandMapperDTO;
import org.axenov.shop.servlet.mapper.Impl.BrandMapperDTOImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
    class BrandMapperDTOTest {

        @Test
        void testToBrandDTO() {

           Brand brand = new Brand(1L, "Apple",null);
            BrandMapperDTO brandMapperDTO=new BrandMapperDTOImpl();
            BrandDTO brandDTO = brandMapperDTO.toBrandDTO(brand);

            assertEquals(brand.getIdBrand(), brandDTO.getIdBrand());
            assertEquals(brand.getNameBrand(), brandDTO.getNameBrand());
            assertEquals(brand.getFastenerList(), brandDTO.getFastenerList());

        }

        @Test
        void testToBrand() {
            BrandDTO brandDTO = new BrandDTO(1L, "Apple",null);
            BrandMapperDTO brandMapperDTO=new BrandMapperDTOImpl();
            Brand brand = brandMapperDTO.toBrand(brandDTO);
         //   Brand brand = BrandMapperDTO.INSTANCE.toBrand(brandDTO);

            assertEquals(brandDTO.getIdBrand(), brand.getIdBrand());
            assertEquals( brandDTO.getNameBrand(), brand.getNameBrand());
            assertEquals(brandDTO.getFastenerList(), brand.getFastenerList());
        }
    }
