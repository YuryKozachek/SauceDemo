package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithoutUserName() {
        loginPage.open();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не вадидно");
    }

    @Test
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login(user, "");
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
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Kozachek Y.N.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Log In")
    @Story("Login With Password")
    @TmsLink("TT-123")
    @Issue("II-123")
    @Description("Валидный вход")
    public void checkValidLogin() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.getProductsPageOpened();
    }

    @Test
    public void checkLogout() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.getLogout();
        loginPage.checkCurrentUrlLoginPage();
    }

}
