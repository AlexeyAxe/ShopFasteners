package org.axenov.shop;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.db.DBConfiguration;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

            try(Connection connection=ConnectionManagerImpl.dataSource.getConnection()){
            System.out.println(connection.getTransactionIsolation());
        }
//        ConnectionManager connectionManager = new ConnectionManagerImpl();
//        try (Connection connection = connectionManager.getConnection()) {
//            if (connection != null) {
//                System.out.println("Соединение с базой данных успешно установлено!");
//            } else {
//                System.out.println("Не удалось установить соединение с базой данных.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
