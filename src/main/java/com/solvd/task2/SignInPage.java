package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

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
        driver.get(driver.getCurrentUrl());
    }

    public void clickEmailMobileField(WebDriver driver){
        AbstractPage.buttonClick(driver, emailMobileField);
    }

    public void inputEmailMobileField(WebDriver driver, String input){
        AbstractPage.sendKeys(driver, emailMobileField, input);
    }

    public void clickContinueButton(WebDriver driver) {
        AbstractPage.buttonClick(driver, continueButton);
    }

    public void clickPasswordField(WebDriver driver) {
        AbstractPage.buttonClick(driver, passwordField);
    }

    public void inputPasswordField(WebDriver driver, String input) {
        AbstractPage.sendKeys(driver, passwordField, input);
    }

    public void clickSignInButton(WebDriver driver){
        AbstractPage.buttonClick(driver, signInButton);
    }

    public WebElement getEmailMobileField(){
        return emailMobileField;
    }
}
