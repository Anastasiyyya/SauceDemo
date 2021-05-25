package tests;

import com.sun.xml.internal.bind.v2.TODO;
import org.testng.Assert;
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

    @Test
    public void addProductToCartTest(){
        loginPage
                .openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void checkProductPriceTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK),productsPage.getProductPrice(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage
                .openPage()
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void checkQuantityTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductQuantity().toString(),"2");
    }
}
