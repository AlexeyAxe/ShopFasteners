package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.axenov.shop.db.DBConfiguration.getProperties;


public class ConnectionManagerImpl implements ConnectionManager {
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String URL_KEY = "jdbcUrl";
    private static final String DRIVER = "driverClassName";

    public static HikariDataSource dataSource;

    public ConnectionManagerImpl() {
    }

    public ConnectionManagerImpl(HikariDataSource dataSource) {
        this.dataSource= dataSource;
    }

 //   static {
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        dataSource= new HikariDataSource();
//        dataSource.setDriverClassName(DBConfiguration.get(DRIVER));
//        dataSource.setJdbcUrl(DBConfiguration.get(URL_KEY));
//        dataSource.setUsername(DBConfiguration.get(USERNAME_KEY));
//        dataSource.setPassword(DBConfiguration.get(PASSWORD_KEY));
//    }

       @Override
      public Connection getConnection()  {
           try {
               return dataSource.getConnection();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
//    public Connection getConnection()  {
//    try {
//        Class.forName(getProperties(DRIVER));
//    } catch (ClassNotFoundException e) {
//        System.out.println("Database driver not found.");
//        throw new RuntimeException();
//    }
//    try {
//        return DriverManager.getConnection(getProperties(URL_KEY),
//                getProperties(USERNAME_KEY), getProperties(PASSWORD_KEY)
//        );
//    } catch (SQLException e) {
//        System.out.println( "Problem with connection");
//        throw new RuntimeException();
//    }
//}
}


