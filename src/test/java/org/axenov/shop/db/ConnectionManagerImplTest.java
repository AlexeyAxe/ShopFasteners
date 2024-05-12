package org.axenov.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManagerImplTest implements ConnectionManager{
    private final String url;
    private final String username;
    private final String password;

    public ConnectionManagerImplTest(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    @Override
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
