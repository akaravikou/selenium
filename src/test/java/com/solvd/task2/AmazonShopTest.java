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


public class AmazonShopTest extends BaseTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonShopTest.class);

    @Test
    public void checkSignInTest(){
        WebDriver driver = BaseTest.getDriver();
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        amazonMainPage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickEmailMobileField();
        signInPage.inputEmailMobileField(PropertyReader.readProperty("email"));
        signInPage.clickContinueButton();

        signInPage.clickPasswordField();
        signInPage.inputPasswordField(PropertyReader.readProperty("password"));
        signInPage.clickSignInButton();

        String user = amazonMainPage.getUserName();
        Assert.assertEquals(user, "Hello, Anton");
    }

    @Test
    public void checkAddItemInBasketTest(){
        WebDriver driver = BaseTest.getDriver();
        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        amazonMainPage.clickSearchInput();
        amazonMainPage.enterInput(PropertyReader.readProperty("input"));
        amazonMainPage.clickSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickFirstSearchResult();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickHardcoverButton();
        productPage.clickAddToCartButton();
        productPage.clickBasketButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.getTitle().getText().toLowerCase(Locale.ROOT).contains("one percenter revolution"));
        shoppingCartPage.clickProceedToCheckoutButton();

        SignInPage signInPage = new SignInPage(driver);
        SoftAssert softAssert = new SoftAssert();
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
        amazonMainPage.clickSearchInput();
        amazonMainPage.enterInput(type);
        amazonMainPage.clickSearchButton();

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
