package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage extends AbstractPage{

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "#nav-link-accountList")
    private WebElement signInButton;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement accountButton;

    public AmazonMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        driver.get(PropertyReader.readProperty("url"));
    }

    public void enterInput(String itemName){
        sendKeys(searchInput, itemName);
    }

    public void clickSearchButton(){
        buttonClick(searchButton);
    }

    public void clickSignInButton() {
        buttonClick(signInButton);
    }

    public void clickSearchInput() {
        buttonClick(searchInput);
    }

    public String getUserName(){
        return accountButton.getText();
    }
}
