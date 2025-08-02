package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By LOGIN_ERROR = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public LoginPage open() {
        log.info("Open Login Page");
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вxод в систему по логину {user} и паролю {password}")
    public ProductsPage login(String user, String password) {
        log.info("Log in: {}, {} ", user, password);
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        log.info("Get error text");
        return driver.findElement(LOGIN_ERROR).getText();
    }

    public void checkCurrentUrlLoginPage() {
        log.info("Compare URL");
        assertEquals(driver.getCurrentUrl(), BASE_URL);
    }

}