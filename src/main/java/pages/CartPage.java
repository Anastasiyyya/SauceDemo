package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CartPage extends HeaderPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//div[@class='cart_item']";

    /**
     * Open page cart page.
     *
     * @return the cart page
     */
    @Step("Opening Cart Page")
    public CartPage openPage() {
        log.info("Open Cart page URL " + CART_PAGE_URL);
        super.openPage(CART_PAGE_URL);
        return this;
    }

    /**
     * This method gets product price.
     * @param productName
     * @return the product price
     */
    public String getProductPrice(String productName) {
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info(String.format("Get price for product: %s. Price is: %s.", productName, productPrice));
        return productPrice;
    }

    /**
     *
     * @param productName
     * @return
     */
    public CartPage removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,productName))).click();
        log.info(String.format("Remove %s product from cart",productName));
        return this;
    }

    /**
     *  Is product displayed (boolean)
     * @param productName
     * @return boolean
     */
    public boolean isProductDisplayed(String productName){
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * This method gets quantity of products
     * @return size of webElements list
     */
    public Integer getProductQuantity() {
        List<WebElement> webElementList = driver.findElements(By.xpath(CART_ITEM_CONTAINER));
        log.info(String.format("Get quantity of products: %s",webElementList.size()));
        return webElementList.size();
    }
}
