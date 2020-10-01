package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//a[contains(text(), 'Continue Shopping')]");
    public static final By CHECKOUT_BUTTON = By.xpath("//a[contains(text(), 'CHECKOUT')]");
    String removeButtonLocator = "//div[contains(text(), '%s')]/ancestor::div//*[text()='REMOVE']";
    String productLocator = "//div[contains(text(), '%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        return this;
    }


    public CartPage openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        return this;
    }

    public CartPage productShouldBeIntheList(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).isDisplayed();
        return this;
    }


    public CartPage removeProduct(String productName) {
        driver.findElement(By.xpath(String.format(removeButtonLocator, productName))).click();
        return this;
    }

    public ProductsPage clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CheckOutPage clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckOutPage(driver);
    }

    public CartPage checkCart(int quantity) {
        Assert.assertEquals(driver.findElements(By.cssSelector(".cart_item_label")).size(), quantity);
        return this;
    }

}