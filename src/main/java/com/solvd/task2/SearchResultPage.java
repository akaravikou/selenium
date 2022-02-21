package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "[data-component-type = 's-result-info-bar']")
    private WebElement infoBar;

    @FindBy(xpath = "//*[contains(@class, 's-main-slot s-result-list s-search-results')]//*[contains(@class, 's-title-instructions-style')]")
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
        return (long) productBlocks.size();
    }

    public List<String> getProductTitle(){
        return productBlocks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnProductByIndex(Integer index){
        if(productBlocks.size()<index) {
            throw new RuntimeException("This index not exist");
        } else {
            WebElement product = productBlocks.get(index);
            buttonClick(product);
        }
    }

    @Override
    public boolean isPageOpened(){
        return infoBar.isDisplayed();
    }
}
