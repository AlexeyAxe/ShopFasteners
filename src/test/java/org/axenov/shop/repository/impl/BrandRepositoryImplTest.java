package org.axenov.shop.repository.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.BrandRepository;
import org.axenov.shop.repository.mapper.BrandMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BrandRepositoryImplTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private BrandMapper brandMapper;

    private BrandRepositoryImpl brandRepository;

    @BeforeEach
    public void setUp() throws SQLException {
        brandRepository = new BrandRepositoryImpl(connection);
        final String FIND_BY_ID = "SELECT * FROM brand WHERE id_brand = ?";
        when(connection.prepareStatement(BrandRepositoryImpl.FIND_BY_ID)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(brandMapper.mapToBrand(resultSet)).thenReturn(new Brand());
    }

    @Test
    public void testFindById() throws SQLException {
        // Вызов метода findById
        Optional<Brand> brand = brandRepository.findById(1L);

        // Проверка, что метод PreparedStatement.setLong был вызван с правильным аргументом
        verify(preparedStatement).setLong(1, 1L);

        // Проверка, что метод PreparedStatement.executeQuery был вызван
        verify(preparedStatement).executeQuery();

        // Проверка, что метод BrandMapper.mapToBrand был вызван с правильным аргументом
        verify(brandMapper).mapToBrand(resultSet);

        // Проверка, что метод возвращает Optional.of(бренд)
        assertEquals(Optional.of(new Brand()), brand);
    }

    @Test
    public void testFindByIdNotFound() throws SQLException {
        // Изменение поведения ResultSet, чтобы он не содержал результатов
        when(resultSet.next()).thenReturn(false);

        // Вызов метода findById
        Optional<Brand> brand = brandRepository.findById(1L);

        // Проверка, что метод возвращает Optional.empty()
        assertEquals(Optional.empty(), brand);
    }

    @Test
    public void testFindByIdException() throws SQLException {
        // Изменение поведения PreparedStatement.executeQuery(), чтобы вызывать исключение
        when(preparedStatement.executeQuery()).thenThrow(new SQLException());

        // Ожидание выброса исключения RuntimeException
        assertThrows(RuntimeException.class, () -> brandRepository.findById(1L));
    }


    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }
}