package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {

    //TODO:To implement this scenario
    /*loginPage.openPage()
    loginPage.login(username.password
    productsPage.addToCart("Product Item")
    cartPage.openPage()
    cartPage.getQuantity("Product Item")
    cartPage.getPrice("Product Item")
    Assertion*/

    @DataProvider(name = "ProductsAndPrices")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Backpack", "$29.99"}
        };
    }

    @DataProvider(name = "Products")
    public Object[] products() {
        return new Object[]{
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
        };
    }

    @Test(dataProvider = "Products")
    public void addProductToCartWithDataProviderTest(String product){
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        cartPage.openPage();
        Assert.assertTrue(cartPage.isProductDisplayed(product));
    }

    @Test
    public void addProductToCartTest(){
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
    }

    @Test(dataProvider = "Products")
    public void checkProductPriceTest(String product) {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        String productPrice = productsPage.getProductPrice(product);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(product),productPrice);
    }

    @Test(dataProvider = "Products")
    public void removeItemFromCartTest(String product) {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        cartPage
                .openPage()
                .removeProductFromCart(product);
        Assert.assertFalse(cartPage.isProductDisplayed(product));
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkQuantityTest() {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,SAUCE_LABS_BACKPACK);
        productsPage.addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductQuantity().toString(),"2");
    }
}
