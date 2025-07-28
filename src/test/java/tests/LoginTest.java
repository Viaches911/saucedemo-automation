package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.Constants.*;

@Epic("Authentication")
@Feature("Login Functionality")
@Owner("Viacheslav Dzhilov")
public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    @Story("User logs in successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulLogin() {
        LoginPage login = new LoginPage(driver);

        stepLogin(login, VALID_USERNAME, VALID_PASSWORD);
        stepVerifyRedirectToProducts();
    }

    @Test(description = "Verify error message when password is invalid")
    @Story("User enters incorrect password")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        stepLogin(loginPage, "standard_user", "wrong_password");
        stepVerifyErrorMessage(
                loginPage,
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(description = "Verify error when username is empty")
    @Story("User submits form with empty username")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);

        stepLogin(loginPage, "", "secret_sauce");
        stepVerifyErrorMessage(loginPage, "Epic sadface: Username is required");
    }

    @Step("Log in with username: {0} and password: {1}")
    public void stepLogin(LoginPage page, String username, String password) {
        logger.info("Logging in with: " + username + " / " + password);
        page.login(username, password);
    }

    @Step("Verify redirect to products page (/inventory.html)")
    public void stepVerifyRedirectToProducts() {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("/inventory.html"),
                "User is not redirected to Products page.");
    }

    @Step("Verify error message is: {1}")
    public void stepVerifyErrorMessage(LoginPage page, String expectedMessage) {
        String actualError = page.getErrorMessage().trim();
        logger.info("Actual error: " + actualError);
        Assert.assertEquals(actualError, expectedMessage);
    }
}
