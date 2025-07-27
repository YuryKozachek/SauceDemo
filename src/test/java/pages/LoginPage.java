package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By LOGIN_ERROR = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Вxод в систему по логину {user} и паролю {password}")
    public void login(String user, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(LOGIN_ERROR).getText();
    }

    public void checkCurrentUrlLoginPage() {
        assertEquals(driver.getCurrentUrl(), BASE_URL);
    }

}
