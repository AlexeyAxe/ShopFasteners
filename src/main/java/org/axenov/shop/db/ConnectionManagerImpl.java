package org.axenov.shop.db;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;



public class ConnectionManagerImpl implements ConnectionManager {
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String URL_KEY = "jdbcUrl";
    private static final String DRIVER_KEY = "driverClassName";

    public final static HikariDataSource dataSource;

//    public ConnectionManagerImpl() {
//    }

     static {
        loadDriver();
        dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(DBConfiguration.get(URL_KEY));
        dataSource.setUsername(DBConfiguration.get(USERNAME_KEY));
        dataSource.setPassword(DBConfiguration.get(PASSWORD_KEY));
    }

    private static void loadDriver() {
        try {
            Class.forName(DBConfiguration.get(DRIVER_KEY));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
