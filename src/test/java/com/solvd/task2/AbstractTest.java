package com.solvd.task2;

import com.solvd.task2.service.DriverPool;
import com.solvd.task2.service.PropertyReader;
import org.openqa.selenium.WebDriver;
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
        setDriver();
    }

    @AfterMethod
    public void tearDown(){
        WebDriver driver = getDriver();
        driver.quit();
    }
}
