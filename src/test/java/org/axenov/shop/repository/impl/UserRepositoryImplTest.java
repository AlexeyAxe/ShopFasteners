package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManagerImplRepTest;
import org.axenov.shop.db.ConnectionManagerImplTest;
import org.axenov.shop.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.SQLException;
import java.util.List;

import static org.axenov.shop.db.ConnectionManagerImpl.dataSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryImplTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    UserRepositoryImpl userRepository;

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
        userRepository = new UserRepositoryImpl(connectionManager.getConnection());
    }

    @Test
    void shouldGetCustomers() {
        userRepository.save(new User(1,"Ivan","Gorshenev", "ivan@mail.ru"));
        userRepository.save(new User(2,"Alex","Knyazev", "alex@mail.ru"));

        List<User> users =  userRepository.findAll();
        assertEquals(2, users.size());
    }
}