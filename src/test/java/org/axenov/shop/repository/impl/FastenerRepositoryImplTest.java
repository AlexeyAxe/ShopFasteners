package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.repository.FastenerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class FastenerRepositoryImplTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("test")
            .withUsername("testuser")
            .withPassword("password");

    private FastenerRepository repository;
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
        repository = new FastenerRepositoryImpl(connectionProvider);
    }

    @Test
    void testFindById() throws SQLException {

        executeUpdate(connectionProvider,
                "CREATE TABLE fastener(" +
                        "id_fastener serial PRIMARY KEY," +
                        "name_fastener varchar(20)" +
                        ");");

        executeUpdate(connectionProvider, "INSERT INTO fastener(id_fastener,name_fastener) VALUES (1,'anchor')");

        Fastener fastenerExpected = new Fastener(1, "anchor", null);

        Fastener fastenerActual = repository.findById(1L);

        assertEquals(fastenerExpected, fastenerActual);

    }


    private void executeUpdate(ConnectionManager connectionManager, String sql) {
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindAll() {
        Fastener fastener1 = new Fastener(1L, "nail");
        Fastener fastener2 = new Fastener(2L, "dowel");
        repository.save(fastener1);
        repository.save(fastener2);

        List<Fastener> fasteners = repository.findAll();
        assertEquals(2, fasteners.size());
        assertTrue(fasteners.contains(fastener1));
        assertTrue(fasteners.contains(fastener2));
    }

    @Test
    void testSave() {
        Fastener fastener = new Fastener(10L, "Anchor");
        assertTrue(repository.save(fastener));

        Fastener savedFastener = repository.findById(fastener.getIdFastener());
        assertNotNull(savedFastener);
        assertEquals(fastener, savedFastener);
    }

    @Test
    void testDeleteById() {
        Fastener fastener = new Fastener(1L, "screw");
        repository.save(fastener);

        assertTrue(repository.deleteById(1L));
        assertNull(repository.findById(1L));
    }

    @Test
    void testDeleteById_ReturnFalse() {
        Assertions.assertFalse(repository.deleteById(11L));
    }
}