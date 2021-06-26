package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BasePage {

    protected WebDriver driver;

    public static final Logger logger = LogManager.getLogger(BasePage.class);

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

    public void waitForRedrawn(WebElement element){
        pageLoading().until(ExpectedConditions.stalenessOf(element));
    }
}