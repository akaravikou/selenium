package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AmazonMainPage extends AbstractPage {

    @FindBy(css = "#nav-logo-sprites")
    private WebElement logo;

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

    public AmazonMainPage(WebDriver driver) {
        super(driver);
        setPageURL(PropertyReader.readProperty("url"));
    }

    public void enterInput(String itemName) {
        sendKeys(searchInput, itemName);
    }

    public SearchResultPage clickSearchButton() {
        SearchResultPage searchResultPage = null;
        if(isPageOpened()) {
            buttonClick(searchButton);
            searchResultPage = new SearchResultPage(getDriver());
        }
        return searchResultPage;
    }

    public SignInPage clickSignInButton() {
        SignInPage signInPage = null;
        if (isPageOpened()) {
            buttonClick(signInButton);
            signInPage = new SignInPage(getDriver());
        }
        return signInPage;
    }

    public AmazonMainPage clickSearchInput() {
        buttonClick(searchInput);
        return new AmazonMainPage(getDriver());
    }

    public String getUserName() {
        String userName = accountButton.getText();
        String[] arrOfStr = userName.split(" ");
        userName = arrOfStr[1];
        return userName;
    }

    public boolean isPageOpened() {
        return logo.isDisplayed();
    }
}
