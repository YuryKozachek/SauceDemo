package tests;

import org.testng.annotations.Test;

public class CompletedTest extends BaseTest {

    @Test
    public void checkNameProductInCart() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addFirstProductToCart();
        cartPage.getCheckout();
        checkoutPage.setInfoClient("Jon", "Smit", "55AA22");
        productInformationPage.getInformation();
        completedPage.getCompletedOrderText();
    }
}
