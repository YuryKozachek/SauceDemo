package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By NAME_PRODUCT_IN_CART = By.xpath("//div[@data-test='inventory-item-name']");
    private final By PRICE_PRODUCT_IN_CART = By.xpath("//div[@data-test='inventory-item-price']");
    private final By BUTTON_REMOVE_PRODUCT_IN_CART = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private final By PRODUCT_CARD_IN_CART = By.xpath("//div[@data-test='inventory-item']");
    private final By PRODUCT_CARD_OUT_CART = By.xpath("//div[@class='removed_cart_item']");
    private final By BUTTON_CHECKOUT = By.xpath("//button[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getNameProductInCart() {
        return driver.findElement(NAME_PRODUCT_IN_CART).getText();
    }

    public String getPriceProductInCart() {
        return driver.findElement(PRICE_PRODUCT_IN_CART).getText();
    }

    public void removeProductFromCart() {
        driver.findElement(BUTTON_REMOVE_PRODUCT_IN_CART).click();
    }

    public boolean checkProductCardInCart() {
        return driver.findElement(PRODUCT_CARD_IN_CART).isDisplayed();
    }

    public boolean checkProductCardOutCart() {
        return driver.findElement(PRODUCT_CARD_OUT_CART).isDisplayed();
    }

    public void getCheckout() {
        driver.findElement(BUTTON_CHECKOUT).click();
    }
}
