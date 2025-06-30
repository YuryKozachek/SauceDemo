package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletedPage extends BasePage {

    private final By COMPLETED_ORDER_TEXT = By.xpath("//h2[@data-test='complete-header']");

    public CompletedPage(WebDriver driver) {
        super(driver);
    }

    public void getCompletedOrderText() {
        Assert.assertEquals(driver.findElement(COMPLETED_ORDER_TEXT).getText(), "Thank you for your order!");
    }

}
