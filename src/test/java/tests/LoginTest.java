package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.Constants.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage login = new LoginPage(driver);
        login.login(VALID_USERNAME, VALID_PASSWORD);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/inventory.html"), "User is not redirected to Products page.");
    }

    @Test
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error.trim(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testEmptyUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","secret_sauce");

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error.trim(),"Epic sadface: Username is required");
    }


}
