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
public class ConnectionManagerImplTest {

    @Mock
    private DataSource dataSource;

    private ConnectionManagerImplTest databaseConnection;

    public ConnectionManagerImplTest() {
     }

    @BeforeEach
    public void setUp() {
        databaseConnection = new ConnectionManagerImplTest();
    }

    @Test
    void testGetConnection() throws SQLException {
        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);

        Connection actualConnection = databaseConnection.dataSource.getConnection();

        verify(dataSource).getConnection();

        assertEquals(connection, actualConnection);
    }

    @Test
    void testGetConnectionException() throws SQLException {
        when(dataSource.getConnection()).thenThrow(new SQLException());
        assertThrows(RuntimeException.class, () -> databaseConnection.dataSource.getConnection());
    }
}