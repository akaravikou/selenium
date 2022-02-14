package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @FindBy(css = ".a-truncate-cut")
    private WebElement title;

    @FindBy(css = "[data-feature-id = 'proceed-to-checkout-action']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver = driver;
        driver.get(driver.getCurrentUrl());
    }

    public WebElement getTitle(){
        return title;
    }

    public WebElement getProceedToCheckoutButton(){
        return proceedToCheckoutButton;
    }
}
