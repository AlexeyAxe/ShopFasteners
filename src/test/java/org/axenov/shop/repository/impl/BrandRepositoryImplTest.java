package org.axenov.shop.repository.impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.BrandRepository;
import org.axenov.shop.repository.ConnectionManagerImplTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class BrandRepositoryImplTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine");

    private static Connection connection;
    private static BrandRepository brandRepository;

    @BeforeAll
    public static void setUp() throws SQLException, IOException {
        connection = DriverManager.getConnection(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword());
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE brand (id_brand SERIAL PRIMARY KEY, name_brand VARCHAR(10) NOT NULL)");
        ConnectionManagerImplTest connectionManager = new ConnectionManagerImplTest(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        );
        brandRepository = new BrandRepositoryImpl(connectionManager);
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Test
    void testFindById() {
        Brand brand = new Brand(1L, "Apple");
        brandRepository.save(brand);

        Brand foundBrand = brandRepository.findById(1L);
        assertNotNull(foundBrand);
        assertEquals(brand, foundBrand);
    }

    @Test
    void testFindAll() {
        Brand brand1 = new Brand(1L, "Apple");
        Brand brand2 = new Brand(2L, "Samsung");
        brandRepository.save(brand1);
        brandRepository.save(brand2);

        List<Brand> brands = brandRepository.findAll();
        assertEquals(2, brands.size());
        assertTrue(brands.contains(brand1));
        assertTrue(brands.contains(brand2));
    }

    @Test
    void testSave() {
        Brand brand = new Brand(10, "HP");
        assertTrue(brandRepository.save(brand));

        Brand savedBrand = brandRepository.findById(brand.getIdBrand());
        assertNotNull(savedBrand);
        assertEquals(brand, savedBrand);
    }

    @Test
    void testDeleteById() {
        Brand brand = new Brand(1L, "HP");
        brandRepository.save(brand);

        assertTrue(brandRepository.deleteById(1L));
        assertNull(brandRepository.findById(1L));
    }

    @Test
    void testDeleteById_ReturnFalse() {
        Assertions.assertFalse(brandRepository.deleteById(11L));
    }
}
