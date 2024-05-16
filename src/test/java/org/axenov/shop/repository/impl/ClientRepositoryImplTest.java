package org.axenov.shop.repository.impl;

import org.axenov.shop.repository.ClientRepository;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.model.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
class ClientRepositoryImplTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    private static Connection connection;
    private static ClientRepository clientRepository;

    @BeforeAll
    public static void beforeAll() throws SQLException {
        connection = DriverManager.getConnection(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword());
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE client (id_user SERIAL PRIMARY KEY, first_name VARCHAR(10) NOT NULL, last_name VARCHAR(20) NOT NULL, email VARCHAR(30) NOT NULL)");
        ConnectionManagerImplTest connectionManager = new ConnectionManagerImplTest(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        );
        clientRepository = new ClientRepositoryImpl(connectionManager);
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Test
    void testFindById() {
        Client client = new Client(10, "Ivan", "Gorshenev", "ivan@mail.ru");
        clientRepository.save(client);

        Client foundClient = clientRepository.findById(1L);
        assertNotNull(foundClient);
        assertEquals(client, foundClient);
    }

    @Test
    void testFindAll() {
        Client client1 = new Client(10, "Ivan", "Gorshenev", "ivan@mail.ru");
        Client client2 = new Client(11, "Alex", "Knyazev", "alex@mail.ru");
        clientRepository.save(client1);
        clientRepository.save(client2);
        List<Client> clients = clientRepository.findAll();
        assertEquals(2, clients.size());
        assertTrue(clients.contains(client1));
        assertTrue(clients.contains(client2));
    }

    @Test
    void testSave() {
        Client client = new Client(11, "Alex", "Knyazev", "alex@mail.ru");
        assertTrue(clientRepository.save(client));

        Client savedClient = clientRepository.findById(client.getIdUser());
        assertNotNull(savedClient);
        assertEquals(client, savedClient);
    }

    @Test
    void testDeleteById() {
        Client client = new Client(11, "Alex", "Knyazev", "alex@mail.ru");
        clientRepository.save(client);

        assertTrue(clientRepository.deleteById(1L));
        assertNull(clientRepository.findById(1L));
    }

    @Test
    void testDeleteById_ReturnFalse() {
        Assertions.assertFalse(clientRepository.deleteById(11L));
    }
}