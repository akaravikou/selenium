package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {

    public WebDriver driver;

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;

/*    @FindBy(css = "#nav-link-accountList")
    private WebElement signInButton;*/

    public AmazonMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.amazon.com/");
    }

    public void enterInput(String itemName){
        searchInput.sendKeys(itemName);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

/*    public void clickSignInButton() {
        signInButton.click();
    }*/
}
