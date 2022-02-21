package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface DriverPool {

    ThreadLocal <WebDriver> drivers = new ThreadLocal<>();

    default WebDriver getDriver(){
        WebDriver driver = drivers.get();
        if(driver == null){
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }

    default void setDriver(WebDriver driver){
        drivers.set(driver);
    }
    }
