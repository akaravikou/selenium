package com.solvd.task2.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public interface DriverPool {

    Logger LOGGER = LoggerFactory.getLogger(DriverPool.class);
    ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    default WebDriver getDriver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }

    default void setDriver() {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setBrowserName(PropertyReader.readProperty("browser"));
        AbstractDriverOptions<?> option = OptionFactory.createOption(Browser.valueOf(PropertyReader.readProperty("browser").toUpperCase()));
        try {
            WebDriver driver = new RemoteWebDriver(new URL(PropertyReader.readProperty("seleniumHost")), option);
            drivers.set(driver);
        } catch (MalformedURLException e) {
            LOGGER.error("Error in setDriver method,DriverPool interface : " + e.getMessage());
        }
    }
}
