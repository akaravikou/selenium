package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "[data-component-type = 's-result-info-bar']")
    private WebElement infoBar;

    @FindBy(css = "[class*='s-matching-dir sg-col-16-of-20']>.sg-col-inner")
    private List<WebElement> productBlocks;

    @FindBy(css = "[data-index='2']")
    private WebElement firstSearchResult;

//    public SearchResultPage(WebDriver driver, String pageUrl) {
//        super(driver, pageUrl);
//        PageFactory.initElements(driver, this);
//    }

    public SearchResultPage(WebDriver driver){
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public Long getProductNumber(){
        if(isPageOpened()) {
            return (long) productBlocks.size();
        }
        return null;
    }

    public List<String> getProductTitle(){
        return productBlocks.stream()
                .map(productBlock -> productBlock.getText())
                .collect(Collectors.toList());
    }

    public ProductPage clickOnProductByIndex(){
        buttonClick(firstSearchResult);
        return new ProductPage(getDriver());
    }

    public boolean isPageOpened(){
        return infoBar.isDisplayed();
    }
}
