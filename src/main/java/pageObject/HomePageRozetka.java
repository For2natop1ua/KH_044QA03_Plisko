package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageRozetka extends BasePage {

    @FindBy(css = "input.search-form__input")
    private WebElement searchFieldRozetka;
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButtonSubmit;

    public HomePageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePageRozetka verifyLink(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://rozetka.com.ua/");
        return this;
    }

    public ResultsPageRozetka goToResultsPage() {
        searchFieldRozetka.click();
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys("book");
        searchButtonSubmit.click();
        return new ResultsPageRozetka(driver);
    }
}