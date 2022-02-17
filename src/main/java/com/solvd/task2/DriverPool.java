package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface DriverPool {

    static final ThreadLocal <WebDriver> drivers = new ThreadLocal<>();

//    static WebDriver getDriver() {
//        if (pool.get() == null) {
//            pool.set(new ChromeDriver());
//        }
//        return pool.get();
//    }

    default WebDriver getDriver(){
        WebDriver driver = drivers.get();
        if(driver == null){
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }
    }
