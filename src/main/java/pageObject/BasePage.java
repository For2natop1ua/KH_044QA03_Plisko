package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static int[] integerValues(List<WebElement> pricesList){

        String[] str = new String[10];
        int size = str.length;
        for(int i = 0;i<size;i++){
            str[i] = pricesList.get(i).getText().replace(" ", "");
        }
        int[] arr = new int [size];
        for(int i =0; i<size; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
}
