package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.TestListener;

import java.time.Duration;
import java.util.HashMap;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    ChromeOptions chromeOptions;
    Actions actions;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ProductInformationPage productInformationPage;
    CompletedPage completedPage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setSetting(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            chromeOptions = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-infobars");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        actions = new Actions(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productInformationPage = new ProductInformationPage(driver);
        completedPage = new CompletedPage(driver);
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {" ", " ", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        driver.quit();
        softAssert.assertAll();
    }
}