package org.axenov.shop.repository.impl;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.axenov.shop.repository.FastenerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.testcontainers.containers.PostgreSQLContainer;
        import org.testcontainers.junit.jupiter.Container;
        import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.sql.*;

        import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class FastenerRepositoryImplTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.1")
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
    public void testFindById() throws SQLException {

            executeUpdate(connectionProvider,
                    "CREATE TABLE fastener(" +
                            "id_fastener serial PRIMARY KEY," +
                            "name_fastener varchar(20)" +
                            ");");

            executeUpdate(connectionProvider, "INSERT INTO fastener(id_fastener,name_fastener) VALUES (1,'Anchor')");

                Fastener fastenerExpected = new Fastener(1,"Anchor",null);

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
}