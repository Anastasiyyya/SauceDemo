package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.LoginSteps;
import steps.ProductSteps;
import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest implements IConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    ProductSteps productSteps;
    LoginSteps loginSteps;
    /**
     * This method performed before the test method
     * @param context
     */
    @BeforeMethod
    public void initTest(ITestContext context){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver,this);
        //Screenshots (if test failed you can see a screenshot in the report)
        String variable = "driver";
        log.debug("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    /**
     * This method performed after the test method
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    /**
     * This method inits pages
     */
    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productSteps = new ProductSteps(driver);
        loginSteps = new LoginSteps(driver);
    }
}


