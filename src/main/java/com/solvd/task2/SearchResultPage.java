package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    public WebDriver driver;

    @FindBy(css = "[class*='s-matching-dir sg-col-16-of-20']>.sg-col-inner")
    private List<WebElement> productBlocks;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<WebElement> getProductBlocks(){
        return productBlocks;
    }
}
