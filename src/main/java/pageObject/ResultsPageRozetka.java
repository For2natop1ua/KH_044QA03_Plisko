package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPageRozetka extends BasePage {

    By searchResults = By.cssSelector("a.goods-tile__picture");
    @FindBy(xpath = "//a[@href='/monitors/c80089/seller=rozetka/']")
    private WebElement rozetkaSeller;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;
    @FindBy(css = "rz-lazy.app-footer")
    private WebElement footer;

    public ResultsPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForClickable(resultsGrid);
    }

    public ResultsPageGoogle moveToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        return new ResultsPageGoogle(driver);
    }

    public ResultsPageRozetka chooseSeller(){
        rozetkaSeller.click();
        waitForVisibility(catalogSettings);
        return this;
    }

    public ProductPageRozetka goToProductPage() {
        List<WebElement> results = driver.findElements(searchResults);
        results.get(0).click();
        return new ProductPageRozetka(driver);
    }
}