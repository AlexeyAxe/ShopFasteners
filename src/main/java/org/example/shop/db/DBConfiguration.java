package org.example.shop.db;

import com.zaxxer.hikari.HikariConfig;

public class DBConfiguration {

    private DBConfiguration(){

   }
   public static final HikariConfig getHikariConfig() {
        return new HikariConfig("datasource.properties");
    }
}