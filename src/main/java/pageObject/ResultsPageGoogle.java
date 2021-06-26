package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ResultsPageGoogle extends BasePage {

    By searchResults = By.cssSelector("#rso a h3");

    public ResultsPageGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePageRozetka clickFirstResult() {
        BasePage.logger.info("Clicking first result...");
        List<WebElement> results = driver.findElements(searchResults);
        results.get(0).click();
        return new HomePageRozetka(driver);
    }
}