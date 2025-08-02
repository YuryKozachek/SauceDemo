package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class CompletedPage extends BasePage {

    private final By COMPLETED_ORDER_TEXT = By.xpath("//h2[@data-test='complete-header']");

    public CompletedPage(WebDriver driver) {
        super(driver);
    }

    public void checkCompletedOrderText() {
        log.info("check Completed Order Text");
        Assert.assertEquals(driver.findElement(COMPLETED_ORDER_TEXT).getText(), "Thank you for your order!");
    }
}