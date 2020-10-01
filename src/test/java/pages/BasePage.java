package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }



    public abstract BasePage isPageOpened();
    public abstract BasePage openPage();


    public void compareURL (String currentURL ){
        Assert.assertEquals(driver.getCurrentUrl(),currentURL);
    }

}