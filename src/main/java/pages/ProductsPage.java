package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='inventory_item']";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";

    /**
     * This method adds product to cart
     * @param productName
     * @return ProductsPage
     */
    @Step("Add product: {productName} to Cart")
    public ProductsPage addProductToCart(String productName) {
        log.info(String.format("Add product '%s' to cart",productName));
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    return this;
    }

    /**
     * This method shows us that the 'add product to cart' button is displayed
     * @param productName
     * @return boolean
     */
    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,productName))).isDisplayed();
    }

    /**
     * This method shows that the 'remove button' is displayed
     * @param productName
     * @return boolean
     */
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,productName))).isDisplayed();
    }

    /**
     * This method gets product price
     * @param productName
     * @return String 'price of the product'
     */
    public String getProductPrice(String productName) {
        log.info(String.format("Get price for product: %s", productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
}
