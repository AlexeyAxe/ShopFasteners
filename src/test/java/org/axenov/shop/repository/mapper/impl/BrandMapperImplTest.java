package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.mapper.BrandMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BrandMapperImplTest {
    @Mock
    private ResultSet resultSet;

    private BrandMapperImpl brandMapper;

    @BeforeEach
    public void setUp() throws SQLException {
        brandMapper = new BrandMapperImpl();
        when(resultSet.getString("name_brand")).thenReturn("Test Brand");
        when(resultSet.getLong("id_brand")).thenReturn(1L);
    }

    @Test
    public void testMapToBrand() throws SQLException {
        // Вызов метода mapToBrand
        Brand brand = brandMapper.mapToBrand(resultSet);

        // Проверка, что метод ResultSet.getString был вызван с правильным аргументом
        verify(resultSet).getString("name_brand");

        // Проверка, что метод ResultSet.getLong был вызван с правильным аргументом
        verify(resultSet).getLong("id_brand");

        // Проверка, что метод возвращает объект Brand с правильными значениями
        assertEquals("Test Brand", brand.getNameBrand());
        assertEquals(1L, brand.getIdBrand());
    }

    @Test
    void testMapToBrandException() throws SQLException {
        // Изменение поведения ResultSet.getString(), чтобы вызывать исключение
        when(resultSet.getString("name_brand")).thenThrow(new SQLException());

        // Ожидание выброса исключения IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> brandMapper.mapToBrand(resultSet));
    }
}