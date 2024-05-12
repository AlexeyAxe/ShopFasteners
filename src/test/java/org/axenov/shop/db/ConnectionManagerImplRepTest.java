package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
public class ConnectionManagerImplRepTest {


   // @Mock
   // private DataSource dataSource;

    private ConnectionManager databaseConnection;

//    public ConnectionManagerImplTest() {
//     }

    @BeforeEach
    void setUp() {
        databaseConnection = new ConnectionManagerImpl();
    }

//    @Test
//    void testGetConnection() throws SQLException {
//        Connection connection = mock(Connection.class);
//        when(dataSource.getConnection()).thenReturn(connection);
//
//        Connection actualConnection = databaseConnection.dataSource.getConnection();
//
//        verify(dataSource).getConnection();
//
//        assertEquals(connection, actualConnection);
//    }


//    @Test
//    void testGetConnectionException() throws SQLException {
//        when(dataSource.getConnection()).thenThrow(new SQLException());
//        assertThrows(RuntimeException.class, () -> databaseConnection.dataSource.getConnection());
//    }

    @Test
    void getConnectionTest() {
        try (Connection conn = databaseConnection.getConnection()) {
            System.out.println("Connection to DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }
}