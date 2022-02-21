package com.solvd.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Locale;

public class AmazonShopTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonShopTest.class);

    @Test
    public void checkSignInTest() {

        AmazonMainPage amazonMainPage = new AmazonMainPage(getDriver());

        amazonMainPage.openPage();

        SignInPage signInPage = amazonMainPage.clickSignInButton();

        signInPage.clickEmailMobileField().inputEmailMobileField(PropertyReader.readProperty("email"));
        signInPage.clickContinueButton().clickPasswordField().inputPasswordField(PropertyReader.readProperty("password"));
        signInPage.clickSignInButton();

        String userName = amazonMainPage.getUserName();
        Assert.assertEquals(userName, PropertyReader.readProperty("userName"), "Name of account should contains user name");
    }

    @Test
    public void checkAddItemInBasketTest() {
        AmazonMainPage amazonMainPage = new AmazonMainPage(getDriver());
        amazonMainPage.openPage();
        amazonMainPage.clickSearchInput().enterInput(PropertyReader.readProperty("input"));

        SearchResultPage searchResultPage = amazonMainPage.clickSearchButton();

        searchResultPage.clickOnProductByIndex(100);

        ProductPage productPage = new ProductPage(getDriver());

        productPage.clickHardcoverButton();
        productPage.clickAddToCartButton();

        ShoppingCartPage shoppingCartPage = productPage.clickBasketButton();

        Assert.assertTrue(shoppingCartPage.getTitleText().toLowerCase(Locale.ROOT).contains("one percenter revolution"),
                "Product in Shopping Cart with incorrect title.");

        SignInPage signInPage = shoppingCartPage.clickProceedToCheckoutButton();

        Assert.assertTrue(signInPage.getEmailMobileFieldText().toLowerCase(Locale.ROOT).contains("email or mobile phone number"),
                "Redirect in wrong page.");
    }

    @DataProvider(name = "typeOfClothing")
    public Object[][] type() {
        return new Object[][]{{"t-shirt"}, {"pants"}, {"socks"}, {"hats"}, {"sweaters"}, {"hoodies"}, {"footwear"}};
    }

    @Test(dataProvider = "typeOfClothing")
    public void checkSearchTypeOfClothingTest(String type) {
        AmazonMainPage amazonMainPage = new AmazonMainPage(getDriver());
        amazonMainPage.openPage();
        amazonMainPage.clickSearchInput();
        amazonMainPage.enterInput(type);

        SearchResultPage searchResultPage = amazonMainPage.clickSearchButton();
        
        Assert.assertNotEquals(searchResultPage.getProductNumber(),0L,"There are no products with this type - " + type);


        SoftAssert softAssert = new SoftAssert();
        searchResultPage.getProductTitle().forEach(title -> {
            softAssert.assertTrue(title.toLowerCase(Locale.ROOT).contains(type.toLowerCase(Locale.ROOT)),"This product doesn't contain " + type);
            LOGGER.info(type);
        });
        softAssert.assertAll();
    }
}
