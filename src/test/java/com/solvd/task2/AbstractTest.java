package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/akaravikou/Documents/selenium_old/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkSignInTest(){
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        AbstractPage.buttonClick(driver, amazonMainPage.getSignInButton());

        SignInPage signInPage = new SignInPage(driver);
        AbstractPage.buttonClick(driver,signInPage.getEmailMobileField());
        AbstractPage.sendKeys(driver, signInPage.getEmailMobileField(), "antontenix@gmail.com");
        AbstractPage.buttonClick(driver, signInPage.getContinueButton());

        AbstractPage.buttonClick(driver, signInPage.getPasswordField());
        AbstractPage.sendKeys(driver, signInPage.getPasswordField(), "experiment");
        AbstractPage.buttonClick(driver, signInPage.getSignInButton());

        String user = amazonMainPage.getUserName();
        Assert.assertEquals(user, "Hello, Anton");
    }

    @AfterMethod
    public void complete(){
        driver.quit();
    }
}
