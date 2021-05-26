package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements IConstants {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage
                .openPage()
                .login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage
                .openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}
