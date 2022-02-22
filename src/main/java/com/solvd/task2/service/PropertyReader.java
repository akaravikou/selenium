package com.solvd.task2.service;

import org.openqa.selenium.safari.SafariOptions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader instance;

    public static String getProperty(Property propertyName){
        String value = null;
        switch(propertyName){
            case URL:
                value = readProperty("url");
                break;
            case DRIVER:
                value = readProperty("driver");
                break;
            case CHROMEDRIVER:
                value = readProperty("chromedriver");
                break;
            case EMAIl:
                value = readProperty("email");
                break;
            case PASSWORD:
                value = readProperty("password");
                break;
            case INPUT:
                value = readProperty("input");
                break;
            case USERNAME:
                value = readProperty("userName");
                break;
            case BROWSER:
                value = readProperty("browser");
                break;
            case SELENIUM_HOST:
                value = readProperty("seleniumHost");
                break;
            default:
                break;
        }
        return value;
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