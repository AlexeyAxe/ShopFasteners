package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Order;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.repository.OrderRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class OrderRepositoryImplTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.1")
            .withDatabaseName("test")
            .withUsername("testuser")
            .withPassword("password");

    private OrderRepository repository;
    ConnectionManager connectionProvider;

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @BeforeEach
    void setUp() {
        connectionProvider = new ConnectionManagerImplTest(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        );
        repository = new OrderRepositoryImpl(connectionProvider);
    }

    @Test
    public void testFindById() throws SQLException {

        executeUpdate(connectionProvider,

                "CREATE TABLE order(" +
                        "id_order serial PRIMARY KEY," +
                        "date_order date not null," +
                        "status varchar(14) not null," +
                        "id_user serial," +
                       "id_fastener serial" +
                        "quantity integer not null," +
                        ");");

        executeUpdate(connectionProvider, "INSERT INTO order(id_order,date_order,status,id_user,id_fastener,quantity) " +
                "VALUES (1,'2024-04-18','PLACED', 6, 1, 10)");

        Order orderExpected = new Order(1, LocalDate.of(2024,4,18),"PLACED", 6, 1, 10 );

        Order orderActual = repository.findById(1L);

        assertEquals(orderExpected, orderActual);

    }


    private void executeUpdate(ConnectionManager connectionManager, String sql) {
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}