package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductInformationPage extends BasePage {

    private final By BUTTON_FINISH = By.xpath("//button[@id='finish']");

    public ProductInformationPage(WebDriver driver) {
        super(driver);
    }

    public CompletedPage getInformation() {
        log.info("get Information Product");
        driver.findElement(BUTTON_FINISH).click();
        return new CompletedPage(driver);
    }
}