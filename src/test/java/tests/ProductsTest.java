package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {

    /**
     * This test checks if the cart button has been displayed
     */
    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    /**
     * This test checks if the remove button has been displayed
     */
    @Test
    public void isRemoveButtonDisplayedTest() {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}
