package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password, String errorTextMessage) {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(username, password);
        return this;
    }
}
