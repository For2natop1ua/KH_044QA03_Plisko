package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public void waitForClickable(WebElement element) {
        WebDriverWait pageLoading = new WebDriverWait(driver, 5);
        pageLoading.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait pageLoading = new WebDriverWait(driver, 5);
        pageLoading.until(ExpectedConditions.visibilityOf(element));
    }
}
