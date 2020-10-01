package tests;


import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void correctLogin() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
    }

    @Test
    public void EmptyLogin() {
        loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage("Epic sadface: Username is required")
                .isPageOpened();
    }

    @Test
    public void EmptyPassword() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "")
                .getErrorMessage("Epic sadface: Password is required")
                .isPageOpened();
    }

    @Test
    public void IncorrectData() {
        loginPage
                .openPage()
                .loginWithoutRedirect("qwer", "123")
                .getErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .isPageOpened();
    }

}