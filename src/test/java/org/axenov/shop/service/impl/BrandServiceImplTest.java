package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.BrandRepository;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;
import org.axenov.shop.repository.mapper.BrandMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {
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
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private BrandMapper brandMapper;

    @BeforeEach
    void setup() throws SQLException, IOException {
        connectionManager = mock(ConnectionManager.class);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        brandMapper = mock(BrandMapper.class);

        when(connectionManager.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        brandRepository = new BrandRepositoryImpl(connectionManager);
    }
    @Test
    void findAllTest() throws SQLException, IOException {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(brandMapper.mapToBrand(resultSet)).thenReturn(new Brand());

        List<Brand> brands = brandRepository.findAll();

        assertTrue(!brands.isEmpty());
        verify(connectionManager, times(1)).getConnection();
        verify(preparedStatement, times(1)).executeQuery();
        verify(resultSet, times(2)).next();
    }
}