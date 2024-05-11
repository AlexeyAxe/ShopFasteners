package org.axenov.shop.service.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    private BrandServiceImpl brandService;

    @BeforeEach
    public void setUp() {
        brandService = new BrandServiceImpl(brandRepository);
    }

    @Test
    void testSave() {
        // Создать фиктивный объект Brand
        Brand brand = new Brand();
        brand.setNameBrand("Test Brand");

        // Вызвать метод save
        boolean saved = brandService.save(brand);

        // Проверить, что метод BrandRepository.save был вызван
        verify(brandRepository).save(brand);

        // Проверить, что метод возвращает true
        assertEquals(true, saved);
    }

    @Test
    void testFindById() {
        // Создать фиктивный объект Brand
        Brand brand = new Brand();
        brand.setNameBrand("Test Brand");
        brand.setIdBrand(1L);

        // Настроить фиктивный объект BrandRepository.findById() для возврата фиктивного объекта Brand
        when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));

        // Вызвать метод findById
        Brand foundBrand = brandService.findById(1L);

        // Проверить, что метод BrandRepository.findById был вызван
        verify(brandRepository).findById(1L);

        // Проверить, что метод возвращает фиктивный объект Brand
        assertEquals(brand, foundBrand);
    }
}