package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {
    private static final String EMPTY_FIELDS_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_PASSWORD_FIELD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

   @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .login(EMPTY_STRING, EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage
                .openPage()
                .login(EMPTY_STRING, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage
                .openPage()
                .login(USERNAME, EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginPage
                .openPage()
                .login("v1", "v1");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }
}
