package com.solvd.task2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader instance;

    public static final String URL;
    public static final String DRIVER;
    public static final String CHROMEDRIVER;
    public static final String EMAIL;
    public static final String PASSWORD;
    public static final String INPUT;
    public static final String USERNAME;

    static{
        URL = readProperty("url");
        DRIVER = readProperty("driver");
        CHROMEDRIVER = readProperty("chromedriver");
        EMAIL = readProperty("email");
        PASSWORD = readProperty("password");
        INPUT = readProperty("input");
        USERNAME = readProperty("userName");
    }

    public static PropertyReader getInstance(){
        PropertyReader localInstance = instance;
        if (localInstance == null) {
            synchronized (PropertyReader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PropertyReader();
                }
            }
        }
        return localInstance;
    }

    public static String readProperty(String field){
        Properties prop = new Properties();
        Properties prop2 = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/akaravikou/IdeaProjects/task2/src/main/resources/conf.properties");
            prop.load(input);
            InputStream input2 = new FileInputStream("/Users/akaravikou/IdeaProjects/task2/src/main/resources/testdata.properties");
            prop2.load(input2);
            prop.putAll(prop2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(field);
    }
}