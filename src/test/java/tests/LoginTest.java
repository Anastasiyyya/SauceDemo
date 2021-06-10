package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {

    @DataProvider(name = "Incorrect data")
    public Object[][] incorrectDataWithErrorMessages() {
        return new Object[][]{
                {EMPTY_LOGIN, EMPTY_PASSWORD,EMPTY_FIELDS_ERROR_TEXT},
                {EMPTY_LOGIN, PASSWORD,EMPTY_FIELDS_ERROR_TEXT},
                {USERNAME, EMPTY_PASSWORD,EMPTY_PASSWORD_FIELD_ERROR_TEXT},
                {"v1", "v1",INCORRECT_DATA_IN_FIELDS_ERROR_TEXT}
        };
    }

    @Test(dataProvider = "Incorrect data")
    public void loginWithIncorrectDataTest(String username, String password, String errorTextMessage) {
        loginSteps.loginAndWaitForPageOpened(username,password,errorTextMessage);
        Assert.assertEquals(loginPage.getErrorMessageText(), errorTextMessage);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(EMPTY_LOGIN,EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginSteps.loginAndWaitForPageOpened(EMPTY_LOGIN,PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginSteps.loginAndWaitForPageOpened(USERNAME,EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_FIELD_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginSteps.loginAndWaitForPageOpened("v1","v1");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }
}
