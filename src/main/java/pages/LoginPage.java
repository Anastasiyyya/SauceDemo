package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//*[@class='bot_column']")
    public WebElement botLogo;

    private static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT  =
            "Epic sadface: Username and password do not match any user in this service";

    /**
     * This method logins on site
     * @param username
     * @param password
     * @return ProductsPage
     */
    public ProductsPage login(String username, String password) {
        log.info(String.format("Fill in username: '%s' in Login field.", username));
        usernameInput.sendKeys(username);
        log.info(String.format("Fill in password: '%s' in Password field.", password));
        passwordInput.sendKeys(password);
        log.info("Click Login button.");
        loginButton.click();
        return new ProductsPage(driver);
    }

    /**
     * This method tries to login on the site with error
     * @param username
     * @param password
     * @return LoginPage
     */
    public LoginPage loginWithError(String username, String password) {
        log.info(String.format("Fill in username: '%s' in Login field.", username));
        usernameInput.sendKeys(username);
        log.info(String.format("Fill in password: '%s' in Password field.", password));
        passwordInput.sendKeys(password);
        log.info("Click Login button.");
        loginButton.click();
        return this;
    }


    @Step("Open Login Page")
    public LoginPage openPage() {
        log.info("Open Login page, URL: " + LOGIN_PAGE_URL);
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    /**
     * This method gets an error message text
     * @return
     */
    public String getErrorMessageText() {
        String text = errorMessage.getText();
        log.info(String.format("Get an error message: %s.", text));
        return text;
    }

    /**
     * This method waits for the page to be opened
     * @return LoginPage
     */
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(botLogo));
        return this;
    }
}
