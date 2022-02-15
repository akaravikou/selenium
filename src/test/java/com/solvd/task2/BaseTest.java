package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ThreadLocal <ChromeDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        if (driver.get() == null) {
        driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod
    public void tearDown(){
        if (driver.get() != null) {
            driver.remove();
        }
    }
}
