package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    //loginPage.openPage()
    //loginPage.login(username.password
    //productsPage.addToCart("Product Item")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Item")
    //cartPage.getPrice("Product Item")
    //Assertion

    @Test
    public void addProductToCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void checkProductPriceTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        String productPrice = productsPage.getProductPrice(SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK),productPrice);
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        cartPage.removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void checkQuantityTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        productsPage.addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity().toString(),"2");
    }
}
