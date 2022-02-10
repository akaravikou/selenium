package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Property {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public static void buttonClick(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void sendKeys(WebDriver driver, WebElement element, String string) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element)).sendKeys(string);
    }
}
