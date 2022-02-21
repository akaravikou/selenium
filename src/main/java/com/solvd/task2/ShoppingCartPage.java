package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(css = "#sc-active-cart")
    private WebElement activeCart;

    @FindBy(css = ".a-truncate-cut")
    private WebElement title;

    @FindBy(css = "[data-feature-id = 'proceed-to-checkout-action']")
    private WebElement proceedToCheckoutButton;

//    public ShoppingCartPage(WebDriver driver, String pageUrl) {
//        super(driver, pageUrl);
//        PageFactory.initElements(driver, this);
//    }

    public ShoppingCartPage(WebDriver driver){
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public String getTitleText(){
        isPageOpened();
        return title.getText();
    }

    public SignInPage clickProceedToCheckoutButton() {
        SignInPage signInPage = null;
        if (isPageOpened()) {
            buttonClick(proceedToCheckoutButton);
            signInPage = new SignInPage(getDriver());
        }
        return signInPage;
    }

    public boolean isPageOpened(){
        return activeCart.isDisplayed();
    }
}
