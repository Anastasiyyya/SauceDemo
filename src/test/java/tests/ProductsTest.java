package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}
