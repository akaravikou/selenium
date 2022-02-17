package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "[class*='s-matching-dir sg-col-16-of-20']>.sg-col-inner")
    private List<WebElement> productBlocks;

    @FindBy(css = "h2>[href *= '/One-Percenter-Revolution-Dave-Nichols-ebook/']")
    private WebElement firstSearchResult;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Long getProductNumber(){
        return productBlocks.stream().count();
    }

    public List<String> getProductTitle(){
        return productBlocks.stream()
                .map(productBlock -> productBlock.getText())
                .collect(Collectors.toList());
    }

    public ProductPage clickFirstSearchResult() {
        buttonClick(firstSearchResult);
        return new ProductPage(getDriver());
    }
}
