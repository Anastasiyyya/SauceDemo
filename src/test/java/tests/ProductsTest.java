package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME,PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}
