package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConfigurationTest {

    @BeforeAll
    public static void loadProperties() {
        DBConfiguration.getProperties("username");
    }

    @Test
    public void shouldReturnCorrectValueGivenExistingKey() {
        String actualValue = DBConfiguration.getProperties("username");
        assertEquals("postgres", actualValue);
    }

    @Test
    public void shouldReturnNullGivenNonExistingKey() {
        // Act
        String actualValue = DBConfiguration.getProperties("nonExistingKey");

        // Assert
        assertNull(actualValue);
    }
}