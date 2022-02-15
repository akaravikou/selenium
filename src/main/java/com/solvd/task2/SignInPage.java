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

    public void clickEmailMobileField(){
        buttonClick(emailMobileField);
    }

    public void inputEmailMobileField(String input){
        sendKeys(emailMobileField, input);
    }

    public void clickContinueButton() {
        buttonClick(continueButton);
    }

    public void clickPasswordField() {
        buttonClick(passwordField);
    }

    public void inputPasswordField(String input) {
        sendKeys(passwordField, input);
    }

    public void clickSignInButton(){
        buttonClick(signInButton);
    }

    public WebElement getEmailMobileField(){
        return emailMobileField;
    }
}
