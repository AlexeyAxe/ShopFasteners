package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionManagerImplRepTest {

    private ConnectionManager databaseConnection;

    @BeforeEach
    void setUp() {
        databaseConnection = new ConnectionManagerImpl();
    }

    @Test
    void getConnectionTest() {
        try (Connection connection = databaseConnection.getConnection()) {
            System.out.println("Connection to DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }
}