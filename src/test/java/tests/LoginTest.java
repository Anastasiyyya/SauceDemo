package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private static final String EMPTY_FIELDS_ERROR_TEXT  = "Epic sadface: Username is required";
    private static final String EMPTY_PASSWORD_FIELD_ERROR_TEXT  = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT  = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMessageText(),EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessageText(),EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessageText(),EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("v1","v1");
        Assert.assertEquals(loginPage.getErrorMessageText(),INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }
}
