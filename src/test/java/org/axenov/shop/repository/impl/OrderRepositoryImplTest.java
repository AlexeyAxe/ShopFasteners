package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Order;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.repository.mapper.impl.OrderMapperImpl;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Testcontainers
class OrderRepositoryImplTest {
    private static final String FIND_BY_ID = "SELECT * FROM order WHERE id_order = ?";
    private static final String FIND_ALL = "SELECT * FROM order";
    private static final String DELETE_BY_ID = "DELETE * FROM order WHERE id_order = ?";
    private static final String SAVE = "INSERT INTO order (id_order,date_order,status,id_user,id_fastener,quantity) VALUES = (?,?,?,?,?,?)";

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    OrderRepositoryImpl orderRepository;

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }


    @BeforeEach
    void setUp() throws SQLException {
        ConnectionManagerImplTest connectionManager = new ConnectionManagerImplTest(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        );
        orderRepository = new OrderRepositoryImpl(connectionManager);
    }

    @Test
    void testFindById() throws SQLException, IOException {
        ConnectionManager mockConnectionManager = mock(ConnectionManager.class);
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        OrderMapperImpl mockOrderMapper = mock(OrderMapperImpl.class);
        Order expectedOrder = new Order();

        when(mockConnectionManager.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(FIND_BY_ID)).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockOrderMapper.mapToOrder(mockResultSet)).thenReturn(expectedOrder);

        orderRepository = new OrderRepositoryImpl(mockConnectionManager);

        Order actualOrder = orderRepository.findById(1L);

        assertNotNull(actualOrder);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testDeleteById() {
        Order expected = new Order(9, LocalDate.of(2024, 5, 12), "PLACED", 2, 2, 15);
        orderRepository.save(new Order(9, LocalDate.of(2024, 5, 12), "PLACED", 2, 2, 15));
        Assertions.assertTrue(orderRepository.deleteById(expected.getIdOrder()));
    }

    @Test
    void testDeleteById_ReturnFalse() {
        Assertions.assertFalse(orderRepository.deleteById(11L));
    }


    @Test
    void testFindByALL() {
        List<Order> orders;
        orderRepository.save(new Order(9, LocalDate.of(2024, 5, 12), "PLACED", 2, 2, 15));
        orderRepository.save(new Order(10, LocalDate.of(2024, 5, 13), "CANCELED", 1, 3, 45));
        orders = orderRepository.findAll();

        System.out.println(orders);

        Assertions.assertEquals(2, orders.size());
    }

    @Test
    void testSave() {
        Order order = new Order(9, LocalDate.of(2024, 5, 12), "PLACED", 2, 2, 15);
        assertTrue(orderRepository.save(order));

        Order savedOrder = orderRepository.findById(order.getIdOrder());
        Assertions.assertNotNull(savedOrder);
        assertEquals(order, savedOrder);
    }

    @After
    void cleanUp() {
    }
}
