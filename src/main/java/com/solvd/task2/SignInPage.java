package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public WebDriver driver;

    @FindBy(css = "#ap_email")
    private WebElement emailMobileField;

    @FindBy(css = ".a-button-input")
    private WebElement continueButton;

    @FindBy(css = "[type*='password']")
    private WebElement passwordField;

    @FindBy(css = "#signInSubmit")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public WebElement getEmailMobileField(){
        return emailMobileField;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton(){
        return signInButton;
    }


}
