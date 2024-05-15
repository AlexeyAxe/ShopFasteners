package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.mapper.impl.BrandMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BrandRepositoryImplTest {
    @Mock
    private ConnectionManagerImpl connectionManager;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private BrandMapperImpl brandMapper;

    private BrandRepositoryImpl brandRepository;

    @BeforeEach
     void setUp() throws SQLException {
        brandRepository = new BrandRepositoryImpl(connectionManager);
        when(connectionManager.getConnection().prepareStatement(BrandRepositoryImpl.FIND_BY_ID)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(brandMapper.mapToBrand(resultSet)).thenReturn(new Brand());
    }

    @Test
     void testFindById() throws SQLException {
        Brand brand = brandRepository.findById(1L);

       verify(preparedStatement).setLong(1, 1L);

     verify(preparedStatement).executeQuery();

       verify(brandMapper).mapToBrand(resultSet);

        assertEquals(new Brand(), brand);
    }

    @Test
     void testFindByIdNotFound() throws SQLException {
        when(resultSet.next()).thenReturn(false);

        Brand brand = brandRepository.findById(1L);

        assertEquals(Optional.empty(), brand);
    }

    @Test
     void testFindByIdException() throws SQLException {
        when(preparedStatement.executeQuery()).thenThrow(new SQLException());

        assertThrows(RuntimeException.class, () -> brandRepository.findById(1L));
    }

}