package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.mapper.FastenerMapper;
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

@ExtendWith(MockitoExtension.class)
class FastenerMapperImplTest {

    @Mock
    private ResultSet resultSet;

    private FastenerMapper fastenerMapper;

    @BeforeEach
    public void setUp() throws SQLException {
        fastenerMapper = new FastenerMapperImpl();
        when(resultSet.getString("name_fastener")).thenReturn("Test Fastener");
        when(resultSet.getLong("id_fastener")).thenReturn(1L);
    }

    @Test
    void mapToFastenerTest() throws SQLException {
        Fastener fastener = fastenerMapper.mapToFastener(resultSet);
        verify(resultSet).getString("name_fastener");
        verify(resultSet).getLong("id_fastener");
        assertEquals("Test Fastener", fastener.getNameFastener());
        assertEquals(1L, fastener.getIdFastener());
    }
}