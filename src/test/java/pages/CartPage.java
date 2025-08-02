package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("get Name Product In Cart");
        return driver.findElement(NAME_PRODUCT_IN_CART).getText();
    }

    public String getPriceProductInCart() {
        log.info("get Price Product In Cart");
        return driver.findElement(PRICE_PRODUCT_IN_CART).getText();
    }

    public void removeProductFromCart() {
        log.info("remove Product From Cart");
        driver.findElement(BUTTON_REMOVE_PRODUCT_IN_CART).click();
    }

    public boolean checkProductCardInCart() {
        log.info("check Product Card In Cart");
        return driver.findElement(PRODUCT_CARD_IN_CART).isDisplayed();
    }

    public boolean checkProductCardOutCart() {
        log.info("check Product Card Out Cart");
        return driver.findElement(PRODUCT_CARD_OUT_CART).isDisplayed();
    }

    public CheckoutPage getCheckout() {
        log.info("get Checkout");
        driver.findElement(BUTTON_CHECKOUT).click();
        return new CheckoutPage(driver);
    }
}