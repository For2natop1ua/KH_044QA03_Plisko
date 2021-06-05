package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageGoogle extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public HomePageGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePageGoogle openPage() {
        driver.get("https://www.google.com/");
        return this;
    }

    public ResultsPageGoogle goToResultsPage() {
        searchField.click();
        searchField.clear();
        searchField.sendKeys("rozetka");
        searchField.submit();
        return new ResultsPageGoogle(driver);
    }
}