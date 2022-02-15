package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ThreadLocal <ChromeDriver> driverPool = new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        if (driverPool.get() == null) {
        driverPool.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver(){
        return driverPool.get();
    }

    @AfterMethod
    public void tearDown(){
        if (driverPool.get() != null) {
            driverPool.remove();
        }
    }
}
