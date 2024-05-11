package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;

public class DBConfiguration {

    private DBConfiguration(){

   }
   public static HikariConfig getHikariConfig() {
        return new HikariConfig("datasource.properties");
    }
}