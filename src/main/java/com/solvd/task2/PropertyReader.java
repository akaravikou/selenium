package com.solvd.task2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static final String URL;
    public static final String DRIVER;
    public static final String CHROMEDRIVER;
    public static final String EMAIL;
    public static final String PASSWORD;
    public static final String INPUT;

    static{
        URL = readProperty("url");
        DRIVER = readProperty("driver");
        CHROMEDRIVER = readProperty("chromedriver");
        EMAIL = readProperty("email");
        PASSWORD = readProperty("password");
        INPUT = readProperty("input");
    }


    public static String readProperty(String field){
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/akaravikou/IdeaProjects/task2/src/main/resources/conf.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(field);
    }
}