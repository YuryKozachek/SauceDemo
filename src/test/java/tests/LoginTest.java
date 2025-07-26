package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(priority = 2, description = "Проверка входа в систему без логина", testName = "Негативный тест вход без логина")
    public void checkLoginWithoutUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не вадидно");
    }

    @Test(priority = 1, description = "Проверка входа в систему без пароля", testName = "Негативный тест вход без пароля")
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не вадидно");
    }

    @Test(priority = 3, description = "Проверка входа в систему без логина и пароля", testName = "Негативный тест вход без логина и пароля")
    public void checkLoginWithoutEmptyValues() {
        loginPage.open();
        loginPage.login(" ", " ");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не вадидно");
    }

    @Test(priority = 0, description = "Проверка входа в систему", testName = "Позитивный тест вход в систему", groups = {"smoke"})
    public void checkValidLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.getProductsPageOpened();
    }

    @Test(priority = 4, description = "Проверка разлогин", testName = "Позитивный тест разлогин", groups = {"smoke"})
    public void checkLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.getLogout();
        loginPage.checkCurrentUrlLoginPage();
    }

    @Test(dataProvider = "LoginData", priority = 5, description = "Параметризация тестов LoginData", testName = "Параметризация тестов LoginData")
    public void checkLoginWithNegativeValues(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не вадидно");
    }
}