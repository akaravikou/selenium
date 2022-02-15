package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class AmazonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonTest.class);

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/akaravikou/Documents/selenium_old/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckSearchInputTest(){
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        amazonMainPage.enterInput(driver,"Alice in wonderland book");
        amazonMainPage.clickSearchButton(driver);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchItems = searchResultPage.getProductBlocks();
        Assert.assertFalse(searchItems.isEmpty(), "There is no items with this name");

        SoftAssert softAssert = new SoftAssert();
        searchItems.forEach(searchItem -> {
            softAssert.assertTrue(searchItem.getText().toLowerCase(Locale.ROOT).contains("alice in wonderland book"));
            LOGGER.info(searchItem.getText());
        });
        softAssert.assertAll();
    }

    @AfterMethod
    public void complete(){
        driver.quit();
    }
}
