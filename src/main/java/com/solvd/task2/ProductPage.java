package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(css = "#productTitle")
    private WebElement title;

    @FindBy(css = "#a-autoid-2-announce")
    private WebElement hardcoverButton;

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "#nav-cart-count")
    private WebElement basketButton;

//    public ProductPage(WebDriver driver, String pageUrl) {
//        super(driver, pageUrl);
//        PageFactory.initElements(driver, this);
//    }

    public ProductPage(WebDriver driver){
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public void clickHardcoverButton(){
        buttonClick(hardcoverButton);
    }

    public void clickAddToCartButton(){
        buttonClick(addToCartButton);
    }

    public ShoppingCartPage clickBasketButton(){
        buttonClick(basketButton);
        return new ShoppingCartPage(getDriver());
    }

    @Override
    public boolean isPageOpened(){
        return title.isDisplayed();
    }
}
