package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkNameProductInCart() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addFirstProductToCart();
        softAssert.assertEquals(productsPage.getNameFirstProduct(), cartPage.getNameProductInCart());
        softAssert.assertEquals(productsPage.getPriceFirstProduct(), cartPage.getPriceProductInCart());
    }

    @Test
    public void checkRemoveProductFromCart() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addFirstProductToCart();
        softAssert.assertTrue(cartPage.checkProductCardInCart());
        cartPage.removeProductFromCart();
        softAssert.assertFalse(cartPage.checkProductCardOutCart());
    }
}
