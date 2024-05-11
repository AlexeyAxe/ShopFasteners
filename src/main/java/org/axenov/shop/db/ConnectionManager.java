package org.axenov.shop.db;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
