package org.axenov.shop.repository.impl;

import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.model.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class ClientRepositoryImplTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    ClientRepositoryImpl clientRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() throws SQLException {
        ConnectionManagerImplTest connectionManager = new ConnectionManagerImplTest(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        clientRepository = new ClientRepositoryImpl(connectionManager);
    }

    @Test
    void shouldGetCustomers() {
        clientRepository.save(new Client(1,"Ivan","Gorshenev", "ivan@mail.ru"));
        clientRepository.save(new Client(2,"Alex","Knyazev", "alex@mail.ru"));

        List<Client> clients =  clientRepository.findAll();
        assertEquals(2, clients.size());
    }
}