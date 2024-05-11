package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.sql.DataSource;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConnectionManagerImplTest {

    @Mock
    private DataSource dataSource;

    private ConnectionManagerImplTest databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new ConnectionManagerImplTest();
    }

    @Test
    public void testGetConnection() throws SQLException {
        // Настроить фиктивный объект DataSource для возврата фиктивного объекта Connection
        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);

        // Вызвать метод getConnection
        Connection actualConnection = databaseConnection.dataSource.getConnection();

        // Проверить, что метод DataSource.getConnection был вызван
        verify(dataSource).getConnection();

        // Проверить, что метод возвращает фиктивный объект Connection
        assertEquals(connection, actualConnection);
    }

    @Test
    public void testGetConnectionException() throws SQLException {
        // Настроить фиктивный объект DataSource для выброса исключения SQLException
        when(dataSource.getConnection()).thenThrow(new SQLException());

        // Ожидание выброса исключения RuntimeException
        assertThrows(RuntimeException.class, () -> databaseConnection.dataSource.getConnection());
    }
}