package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class AbstractTest implements DriverPool {

    private WebDriver driver;

    @BeforeSuite
    public void setUp(){
        PropertyReader propertyReader = PropertyReader.getInstance();
    }

    @BeforeMethod
    public void driverUp(){
        WebDriver driver = new ChromeDriver();
        drivers.set(driver);
    }

    @AfterMethod
    public void tearDown(){
        WebDriver driver = getDriver();
        driver.quit();
    }
}
