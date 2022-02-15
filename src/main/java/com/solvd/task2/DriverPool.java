package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface DriverPool {

    ThreadLocal<ChromeDriver> pool = new ThreadLocal<>();

    default WebDriver getDriver() {


        if (pool.get() == null) {
            pool.set(new ChromeDriver());
        }
        return pool.get();
    }
}