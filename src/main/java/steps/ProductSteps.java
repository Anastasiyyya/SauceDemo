package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    /**
     * Login and add product to cart
     * @param username
     * @param password
     * @param productName
     * @return ProductSteps
     */
    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProduct(String username, String password, String productName) {
        loginPage
                .openPage()
                .login(System.getProperty("username", username), System.getProperty("password", password))
                .addProductToCart(productName);
        return this;
    }
}