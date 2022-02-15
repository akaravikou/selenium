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

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickEmailMobileField(WebDriver driver){
        buttonClick(driver, emailMobileField);
    }

    public void inputEmailMobileField(WebDriver driver, String input){
        sendKeys(driver, emailMobileField, input);
    }

    public void clickContinueButton(WebDriver driver) {
        buttonClick(driver, continueButton);
    }

    public void clickPasswordField(WebDriver driver) {
        buttonClick(driver, passwordField);
    }

    public void inputPasswordField(WebDriver driver, String input) {
        sendKeys(driver, passwordField, input);
    }

    public void clickSignInButton(WebDriver driver){
        buttonClick(driver, signInButton);
    }

    public WebElement getEmailMobileField(){
        return emailMobileField;
    }
}
