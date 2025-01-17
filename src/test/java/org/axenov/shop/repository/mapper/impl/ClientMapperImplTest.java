package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Client;
import org.axenov.shop.repository.mapper.UserMapper;
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
class ClientMapperImplTest {

    @Mock
    private ResultSet resultSet;

    private UserMapper userMapper;

    @BeforeEach
    public void setUp() throws SQLException {
        userMapper = new ClientMapperImpl();
        when(resultSet.getLong("id_user")).thenReturn(2L);
        when(resultSet.getString("first_name")).thenReturn("Test First Name");
        when(resultSet.getString("last_name")).thenReturn("Test Last Name");
        when(resultSet.getString("email")).thenReturn("Test Email");

    }

    @Test
    void mapToUserTest() throws SQLException {
        Client client = userMapper.mapToUser(resultSet);
        verify(resultSet).getLong("id_user");
        verify(resultSet).getString("first_name");
        verify(resultSet).getString("last_name");
        verify(resultSet).getString("email");

        assertEquals(2L, client.getIdUser());
        assertEquals("Test First Name", client.getFirstName());
        assertEquals("Test Last Name", client.getLastName());
        assertEquals("Test Email", client.getEmail());


    }
}
