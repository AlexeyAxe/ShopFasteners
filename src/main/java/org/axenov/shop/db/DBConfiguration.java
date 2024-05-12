package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;

import java.io.IOException;
import java.util.Properties;

public final class DBConfiguration {

    private DBConfiguration(){

   }

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (var inputStream = DBConfiguration.class.getClassLoader().getResourceAsStream("datasourse.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}