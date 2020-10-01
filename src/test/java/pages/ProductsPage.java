package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage isPageOpened() {
        Assert.assertTrue(driver.findElement(SORTING_BUTTON).isDisplayed());
        return this;
    }

    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

    public ProductsPage addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
        return this;
    }

    public ProductsPage cartIsOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn_action.checkout_button")).isDisplayed());
        return this;
    }

    public CartPage goToCart() {
        driver.get("https://www.saucedemo.com/cart.html");
        cartIsOpened();
        return new CartPage(driver);
    }

}