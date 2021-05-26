package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements IConstants {
    private static final String EMPTY_FIELDS_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_PASSWORD_FIELD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

   @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(EMPTY_STRING, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_FIELD_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .loginWithError("v1", "v1")
                .getErrorMessageText();
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }
}
