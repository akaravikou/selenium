package com.solvd.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    public void buttonClick(WebDriver driver, WebElement element) {
        String elementName = element.getAccessibleName();
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
        LOGGER.info("Element " + elementName + " clicked.");
    }

    public void sendKeys(WebDriver driver, WebElement element, String input) {
        String elementName = element.getAccessibleName();
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
        LOGGER.info("In " + elementName + " was entered " + input + ".");
    }
}
