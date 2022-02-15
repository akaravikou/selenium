package com.solvd.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Locale;


public class AbstractTest extends BaseTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    @Test
    public void checkSignInTest(){
        WebDriver driver = BaseTest.getDriver();
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        AbstractPage.buttonClick(driver, amazonMainPage.getSignInButton());

        SignInPage signInPage = new SignInPage(driver);
        AbstractPage.buttonClick(driver,signInPage.getEmailMobileField());
        AbstractPage.sendKeys(driver, signInPage.getEmailMobileField(), PropertyReader.readProperty("email"));
        AbstractPage.buttonClick(driver, signInPage.getContinueButton());

        AbstractPage.buttonClick(driver, signInPage.getPasswordField());
        AbstractPage.sendKeys(driver, signInPage.getPasswordField(), PropertyReader.readProperty("password"));
        AbstractPage.buttonClick(driver, signInPage.getSignInButton());

        String user = amazonMainPage.getUserName();
        Assert.assertEquals(user, "Hello, Anton");
    }

    @Test
    public void checkAddItemInBasketTest(){
        WebDriver driver = BaseTest.getDriver();
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        AbstractPage.buttonClick(driver, amazonMainPage.getSearchInput());
        AbstractPage.sendKeys(driver, amazonMainPage.getSearchInput(), PropertyReader.readProperty("input"));
        AbstractPage.buttonClick(driver, amazonMainPage.getSearchButton());

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        AbstractPage.buttonClick(driver, searchResultPage.getFirstSearchResult());

        ProductPage productPage = new ProductPage(driver);
        AbstractPage.buttonClick(driver, productPage.getHardcoverButton());
        AbstractPage.buttonClick(driver, productPage.getAddToCartButton());
        AbstractPage.buttonClick(driver, productPage.getBasketButton());

        SoftAssert softAssert = new SoftAssert();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        softAssert.assertTrue(shoppingCartPage.getTitle().getText().toLowerCase(Locale.ROOT).contains("one percenter revolution"));
        AbstractPage.buttonClick(driver, shoppingCartPage.getProceedToCheckoutButton());

        SignInPage signInPage = new SignInPage(driver);
        softAssert.assertTrue(signInPage.getEmailMobileField().getText().toLowerCase(Locale.ROOT).contains("email or mobile phone number"));
        softAssert.assertAll();
    }

    @DataProvider(name = "typeOfClothing")
    public Object[][] type() {
        return new Object[][]{{"t-shirt"}, {"pants"}, {"socks"}, {"hats"}, {"sweaters"}, {"hoodies"}, {"footwear"}};
    }

    @Test(dataProvider = "typeOfClothing")
    public void checkSearchTypeOfClothingTest(String type){
        WebDriver driver = BaseTest.getDriver();
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        AbstractPage.buttonClick(driver, amazonMainPage.getSearchInput());
        AbstractPage.sendKeys(driver, amazonMainPage.getSearchInput(), type);
        AbstractPage.buttonClick(driver, amazonMainPage.getSearchButton());

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchItems = searchResultPage.getProductBlocks();
        Assert.assertFalse(searchItems.isEmpty(), "There are no products with this type.");

        SoftAssert softAssert = new SoftAssert();
        searchItems.forEach(searchItem -> {
            softAssert.assertTrue(searchItem.getText().toLowerCase(Locale.ROOT).contains(type.toLowerCase(Locale.ROOT)));
                    LOGGER.info("This product doesn't contain " + type);
            LOGGER.info(searchItem.getText());
        });
        softAssert.assertAll();
    }
}
