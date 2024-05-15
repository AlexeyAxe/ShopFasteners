package org.axenov.shop.service.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BrandServiceImplTest {
    @Mock
    private BrandRepositoryImpl brandRepository;

    @InjectMocks
    private BrandServiceImpl brandService;

    @Test
    void testSave() {
        Brand brand = new Brand();
        brand.setNameBrand("Test Brand");

        boolean saved = brandService.save(brand);

        verify(brandRepository).save(brand);

        assertEquals(true, saved);
    }

    @Test
    void testFindById() {
        Brand brand = new Brand();
        brand.setNameBrand("Test Brand");
        brand.setIdBrand(1L);

        when(brandRepository.findById(1L)).thenReturn(brand);

        Brand foundBrand = brandService.findById(1L);

        verify(brandRepository).findById(1L);

        assertEquals(brand, foundBrand);
    }
}