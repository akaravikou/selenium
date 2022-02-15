package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    private WebDriver driver;

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
    }

    public void clickEmailMobileField(){
        buttonClick(driver, emailMobileField);
    }

    public void inputEmailMobileField(String input){
        sendKeys(driver, emailMobileField, input);
    }

    public void clickContinueButton() {
        buttonClick(driver, continueButton);
    }

    public void clickPasswordField() {
        buttonClick(driver, passwordField);
    }

    public void inputPasswordField(String input) {
        sendKeys(driver, passwordField, input);
    }

    public void clickSignInButton(){
        buttonClick(driver, signInButton);
    }

    public WebElement getEmailMobileField(){
        return emailMobileField;
    }
}
