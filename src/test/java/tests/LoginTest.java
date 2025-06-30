package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithoutUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не вадидно");
    }

    @Test
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не вадидно");
    }

    @Test
    public void checkLoginWithoutEmptyValues() {
        loginPage.open();
        loginPage.login(" ", " ");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не вадидно");
    }

    @Test
    public void checkValidLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.getProductsPageOpened();
    }

    @Test
    public void checkLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.getLogout();
        loginPage.checkCurrentUrlLoginPage();
    }

}
