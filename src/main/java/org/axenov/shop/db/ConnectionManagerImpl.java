package org.axenov.shop.db;

import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionManagerImpl implements ConnectionManager {
    private static final String PASSWORD_KEY = "password";

    private static final String USERNAME_KEY = "username";

    private static final String URL_KEY = "jdbcUrl";

    private static final String DRIVER = "driverClassName";

    public static final HikariDataSource dataSource;

    static {
    //    HikariConfig config=DBConfiguration.getHikariConfig();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dataSource= new HikariDataSource();
        dataSource.setJdbcUrl(DBConfiguration.get(URL_KEY));
        dataSource.setUsername(DBConfiguration.get(USERNAME_KEY));
        dataSource.setPassword(DBConfiguration.get(PASSWORD_KEY));
    }

       @Override
      public Connection getConnection()  {
           try {
               return dataSource.getConnection();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
}


