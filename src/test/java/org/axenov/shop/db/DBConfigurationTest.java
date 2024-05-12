package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConfigurationTest {

    @BeforeAll
    public static void loadProperties() {
        //Этот шаг необходим, чтобы инициализировать статический блок класса
        DBConfiguration.get("testKey");
    }

    @Test
    public void shouldReturnCorrectValueGivenExistingKey() {
        // Act
        String actualValue = DBConfiguration.get("testKey");

        // Assert
        assertEquals("testValue", actualValue);
    }

    @Test
    public void shouldReturnNullGivenNonExistingKey() {
        // Act
        String actualValue = DBConfiguration.get("nonExistingKey");

        // Assert
        assertNull(actualValue);
    }
}