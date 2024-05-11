package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionManagerImpl implements ConnectionManager {
    public static final HikariDataSource dataSource;

    static {
        HikariConfig config=DBConfiguration.getHikariConfig();
        dataSource= new HikariDataSource(config);
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


