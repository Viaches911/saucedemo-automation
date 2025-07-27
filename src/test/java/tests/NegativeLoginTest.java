package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.Constants.*;
import static utils.Constants.VALID_USERNAME;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void invalidCredentialsTest() {
        LoginPage login = new LoginPage(driver);
        login.login(INVALID_USERNAME, INVALID_PASSWORD);

        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.toLowerCase().contains("do not match"), "Expected error not shown");
    }

    @Test
    public void emptyUsernameTest() {
        LoginPage login = new LoginPage(driver);
        login.login("", VALID_PASSWORD);

        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.contains("Username is required"), "Expected username error not shown");
    }

    @Test
    public void emptyPasswordTest() {
        LoginPage login = new LoginPage(driver);
        login.login(VALID_USERNAME, "");

        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.contains("Password is required"), "Expected password error not shown");
    }
}
