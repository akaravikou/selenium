package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

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
