package com.solvd.task2.page;

import com.solvd.task2.service.Property;
import com.solvd.task2.service.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        setPageURL(PropertyReader.getProperty(Property.URL));
    }

    public void enterInput(String itemName) {
        sendKeys(searchInput, itemName);
    }

    public SearchResultPage clickSearchButton() {
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

    public String getUserName() {
        String userName = accountButton.getText();
        String[] arrOfStr = userName.split(" ");
        userName = arrOfStr[1];
        return userName;
    }
}
