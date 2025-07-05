package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInformationPage extends BasePage {

    private final By BUTTON_FINISH = By.xpath("//button[@id='finish']");

    public ProductInformationPage(WebDriver driver) {
        super(driver);
    }

    public void getInformation() {
        driver.findElement(BUTTON_FINISH).click();
    }
}
