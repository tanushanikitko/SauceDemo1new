package tests;


import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test

    public void allItemsTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        menuPage.openMenu()
                .allItemsClick().
                compareURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void aboutItemTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        menuPage.openMenu()
                .aboutClick()
                .compareURL("https://saucelabs.com/");
    }

    @Test
    public void logoutItemtest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        menuPage.openMenu()
                .logOutClick()
                .compareURL("https://www.saucedemo.com/index.html");
    }

    @Test
    public void resetItemTest() throws ElementClickInterceptedException {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage
                .addProduct("Sauce Labs Bike Light")
                .goToCart();
        menuPage
                .openMenu()
                .resetClick();
        driver.navigate().refresh();
        cartPage.checkCart(0);
    }
}