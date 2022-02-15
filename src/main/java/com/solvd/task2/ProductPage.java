package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(css = "#productTitle")
    private WebElement title;

    @FindBy(css = "#a-autoid-2-announce")
    private WebElement hardcoverButton;

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "#nav-cart-count")
    private WebElement basketButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(driver.getCurrentUrl());
    }

    public WebElement getHardcoverButton(){
        return hardcoverButton;
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    public WebElement getBasketButton(){
        return basketButton;
    }
}
