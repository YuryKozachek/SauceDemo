package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage {

    private final By FIRST_NAME = By.xpath("//input[@id='first-name']");
    private final By LAST_NAME = By.xpath("//input[@id='last-name']");
    private final By POSTAL_CODE = By.xpath("//input[@id='postal-code']");
    private final By BUTTON_CONTINUE = By.xpath("//input[@id='continue']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Информация о клиенте, Имя {firstName}, Фамилия {lastName}, код {code}")
    public ProductInformationPage setInfoClient(String firstName, String lastName, String code) {
        log.info("set Info Client: {}, {}, {} ", firstName, lastName, code);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(code);
        driver.findElement(BUTTON_CONTINUE).click();
        return new ProductInformationPage(driver);
    }
}