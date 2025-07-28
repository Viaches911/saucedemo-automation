package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.Constants.BASE_URL;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup(){
        logger.info("Setup WebDriver and browser launching()");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToLoginPage(){
        logger.info("Open Base URL"+ BASE_URL);
        driver.get(BASE_URL);
    }

    @AfterClass
    public void teardown(){
        logger.info("Browser closing");
        if (driver != null) {
            driver.quit();
            logger.info("Browser was closed");
        } else {
            logger.warn("WebDriver was null during closing");
        }
    }
}


