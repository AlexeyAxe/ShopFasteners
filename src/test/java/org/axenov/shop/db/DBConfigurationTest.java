package org.axenov.shop.db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConfigurationTest {

    @BeforeAll
    public static void loadProperties() {
        DBConfiguration.get("testKey");
    }

    @Test
    public void shouldReturnCorrectValueGivenExistingKey() {
        String actualValue = DBConfiguration.get("testKey");
        assertEquals("testValue", actualValue);
    }

    @Test
    public void shouldReturnNullGivenNonExistingKey() {
        String actualValue = DBConfiguration.get("nonExistingKey");

        assertNull(actualValue);
    }
}