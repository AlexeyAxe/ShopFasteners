package org.axenov.shop.db;

import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConfiguration {

    private static final Properties PROPERTIES = new Properties();

    private static final String USERNAME ="postgres";
    private static final String PASSWORD ="POSTGRES";
    private static final String JDBC_URL ="jdbc:postgresql://localhost:5432/postgres";

    private DBConfiguration(){
   }

       static {
           loadProperties();
       }

    private static void loadProperties() {
        try (InputStream resourceAsStream = DBConfiguration.class.getClassLoader().getResourceAsStream("datasourse.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  static  String get (String key){
        return PROPERTIES.getProperty(key);
    }
}