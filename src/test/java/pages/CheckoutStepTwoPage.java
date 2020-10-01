package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepTwoPage extends BasePage {

    public static final By TOTAL_AMOUNT = By.xpath("//div[@class='summary_total_label']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwoPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_AMOUNT));
        return this;
    }

    public CheckoutStepTwoPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        isPageOpened();
        return this;
    }
}