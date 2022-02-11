package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileStartPage {

    public WebDriver driver;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement accountButton;

    public ProfileStartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public String getUserName(){
        String userName = accountButton.getText();
        return userName;
    }
}
