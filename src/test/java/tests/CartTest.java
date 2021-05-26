package tests;

import com.sun.xml.internal.bind.v2.TODO;
import constants.IConstants;
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

    @DataProvider(name = "Входящие данные для Продуктов")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Backpack", "$29.99"}
        };
    }

    @Parameters({"password"})
    @Test(dataProvider = "Входящие данные для Продуктов")
    public void addProductToCartTest(@Optional("1") String p1, String productName, String productPrice) {
        loginPage
                .openPage()
                .login("standard_user", p1)
                .addProductToCart(productName);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice);
    }

    @Test
    public void addProductToCartTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
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
        String productPrice = productsPage.getProductPrice(SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK),productPrice);
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
