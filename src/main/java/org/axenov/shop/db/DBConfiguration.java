package org.axenov.shop.db;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public final class DBConfiguration {

    private static final Properties PROPERTIES = new Properties();

    private DBConfiguration(){
   }

       static {
           loadProperties();
       }

    private static void loadProperties() {
        try (InputStream resourceAsStream = DBConfiguration.class.getClassLoader().getResourceAsStream("datasourse.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  static  String get (String key){
        return PROPERTIES.getProperty(key);
    }
}