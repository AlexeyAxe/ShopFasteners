package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DBConfiguration {

    private DBConfiguration(){

   }



    private static final Properties PROPERTIES = new Properties();
    public static final HikariDataSource dataSource=new HikariDataSource();
    private static final String PROP_PATH="datasource.properties";

    public static String getProperties(String key) {
        try (InputStream inputStream = DBConfiguration.class.getClassLoader().
                getResourceAsStream(PROP_PATH)) {
            PROPERTIES.load(inputStream);
            dataSource.setDriverClassName(PROPERTIES.getProperty("driverClassName"));
            dataSource.setJdbcUrl(PROPERTIES.getProperty("jdbcUrl"));
            dataSource.setUsername(PROPERTIES.getProperty("username"));
            dataSource.setPassword(PROPERTIES.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
        return PROPERTIES.getProperty(key);
    }
//    static {
//        loadProperties();
//    }
//
//    public static String get(String key){
//        return PROPERTIES.getProperty(key);
//    }
//
//    private static void loadProperties() {
//        try (InputStream inputStream = DBConfiguration.class.getClassLoader().
//                getResourceAsStream(PROP_PATH)) {
//            PROPERTIES.load(inputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}