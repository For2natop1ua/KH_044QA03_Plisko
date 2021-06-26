package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    public WebDriverWait pageLoading(){
        return new WebDriverWait(driver, 5);
    }

    public WebDriverWait pageLoading(){
        return new WebDriverWait(driver, 5);
    }

    public Actions newAction(){
        return new Actions(driver);
    }

    public void waitForClickable(WebElement element) {
        pageLoading().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element) {
        pageLoading().until(ExpectedConditions.visibilityOf(element));
    }
}