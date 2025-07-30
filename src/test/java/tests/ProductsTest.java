package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Kozachek Y.N.")
    @Link("https://www.saucedemo.com/")
    @Epic("Products Page")
    @Feature("Products In Cart")
    @Story("Quantity Products In Cart")
    @TmsLink("TT-456")
    @Issue("II-456")
    @Description("Проверьте количество товаров в корзине")

    public void checkQuantityProductsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addThreeProductToCart();
        assertEquals(productsPage.getQuantityProductsInCart(), "3");
    }
}
