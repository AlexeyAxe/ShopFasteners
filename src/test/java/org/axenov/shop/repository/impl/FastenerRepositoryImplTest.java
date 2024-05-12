package org.axenov.shop.repository.impl;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.FastenerRepository;
import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.testcontainers.containers.PostgreSQLContainer;
        import org.testcontainers.junit.jupiter.Container;
        import org.testcontainers.junit.jupiter.Testcontainers;

        import java.sql.*;

        import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class FastenerRepositoryImplTest {

    // Запускаем Postgres контейнер
    @Container
    public PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.1")
            .withDatabaseName("test")
            .withUsername("testuser")
            .withPassword("password");

    @Test
    public void testFindById() throws SQLException {
        // Создаем соединение
        try (Connection connection = DriverManager.getConnection(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword())) {

            // Создаем таблицу
            executeUpdate(connection,
                    "CREATE TABLE fastener(" +
                            "id_fastener integer PRIMARY KEY," +
                            "name_fastener varchar(20)" +
                            ");");

            // Вставляем данные в таблицу
            executeUpdate(connection, "INSERT INTO fastener(id_fastener,name_fastener) VALUES (1,'Anchor')");

            FastenerRepository repository = new FastenerRepositoryImpl(connection);

                Fastener fastenerExpected = new Fastener(1,"Anchor",null);
                // Определите необходимые свойства
                // База данных должна содержать fastener с идентификатором 1

                Fastener fastenerActual = repository.findById(1L);

                assertEquals(fastenerExpected, fastenerActual);

        }
        }

    private void executeUpdate(Connection connection, String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}