package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage {

    private final By CARD_BADGE = By.xpath("//span[@data-test='shopping-cart-badge']");
    private final By NAME_FIRST_PRODUCT = By.xpath("(//div[@data-test='inventory-item-name'])[1]");
    private final By PRICE_FIRST_PRODUCT = By.xpath("(//div[@data-test='inventory-item-price'])[1]");
    private final By BUTTON_ADD_FIRST_PRODUCT = By.xpath("(//button[text()='Add to cart'])[1]");
    private final By BUTTON_ADD_SECOND_PRODUCT = By.xpath("(//button[text()='Add to cart'])[2]");
    private final By BUTTON_ADD_THIRD_PRODUCT = By.xpath("(//button[text()='Add to cart'])[3]");
    private final By SHOPPING_CARD = By.xpath("//div[@id='shopping_cart_container']");
    private final By BURGER_MENU = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By LOGOUT_BUTTON = By.xpath("//*[@id='logout_sidebar_link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы с продуктами")
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void getProductsPageOpened() {
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Step("Добавление первого продукта в корзину")
    public void addFirstProductToCart() {
        driver.findElement(BUTTON_ADD_FIRST_PRODUCT).click();
        driver.findElement(SHOPPING_CARD).click();
    }

    @Step("Добавление трех продуктов в корзину")
    public void addThreeProductToCart() {
        driver.findElement(BUTTON_ADD_FIRST_PRODUCT).click();
        driver.findElement(BUTTON_ADD_SECOND_PRODUCT).click();
        driver.findElement(BUTTON_ADD_THIRD_PRODUCT).click();
    }

    public String getQuantityProductsInCart(){
        return driver.findElement(CARD_BADGE).getText();
    }

    public String getNameFirstProduct() {
        return driver.findElement(NAME_FIRST_PRODUCT).getText();
    }

    public String getPriceFirstProduct() {
        return driver.findElement(PRICE_FIRST_PRODUCT).getText();
    }

    public void getLogout() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
