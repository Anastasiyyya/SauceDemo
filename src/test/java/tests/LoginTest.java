package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements IConstants,ITestConstants {

   @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(EMPTY_LOGIN, EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(EMPTY_LOGIN, PASSWORD);
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
