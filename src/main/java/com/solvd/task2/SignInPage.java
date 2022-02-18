package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    @FindBy(css = "#ap_email")
    private WebElement emailMobileField;

    @FindBy(css = ".a-button-input")
    private WebElement continueButton;

    @FindBy(css = "[type*='password']")
    private WebElement passwordField;

    @FindBy(css = "#signInSubmit")
    private WebElement signInButton;

//    public SignInPage(WebDriver driver, String pageUrl) {
//        super(driver, pageUrl);
//        PageFactory.initElements(driver, this);
//    }

    public SignInPage(WebDriver driver){
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public SignInPage clickEmailMobileField(){
        buttonClick(emailMobileField);
        return new SignInPage(getDriver());
    }

    public SignInPage inputEmailMobileField(String input){
        sendKeys(emailMobileField, input);
        return new SignInPage(getDriver());
    }

    public SignInPage clickContinueButton() {
        buttonClick(continueButton);
        return new SignInPage(getDriver());
    }

    public SignInPage clickPasswordField() {
        buttonClick(passwordField);
        return new SignInPage(getDriver());
    }

    public SignInPage inputPasswordField(String input) {
        sendKeys(passwordField, input);
        return new SignInPage(getDriver());
    }

    public SignInPage clickSignInButton(){
        buttonClick(signInButton);
        return new SignInPage(getDriver());
    }

    public String getEmailMobileFieldText(){
        return emailMobileField.getText();
    }
}
