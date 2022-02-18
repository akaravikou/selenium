package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;

public class AmazonMainPage extends AbstractPage{

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "#nav-link-accountList")
    private WebElement signInButton;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement accountButton;

//    public AmazonMainPage(WebDriver driver){
//        super(driver, PropertyReader.readProperty("url"));
//        PageFactory.initElements(driver, this);
//    }

    public AmazonMainPage(WebDriver driver){
        super(driver);
        setPageURL(PropertyReader.readProperty("url"));
    }

    public void enterInput(String itemName){
        sendKeys(searchInput, itemName);
    }

    public SearchResultPage clickSearchButton(){
        buttonClick(searchButton);
        return new SearchResultPage(getDriver());
    }

    public SignInPage clickSignInButton() {
        buttonClick(signInButton);
        return new SignInPage(getDriver());
    }

    public AmazonMainPage clickSearchInput() {
        buttonClick(searchInput);
        return new AmazonMainPage(getDriver());
    }

    public String getUserName(){
        return accountButton.getText().substring(7);
    }
}
