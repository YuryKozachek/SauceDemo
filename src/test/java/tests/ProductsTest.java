package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test
    public void checkQuantityProductsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addThreeProductToCard();
        assertEquals(productsPage.getQuantityProductsInCart(), "3");
    }
}
