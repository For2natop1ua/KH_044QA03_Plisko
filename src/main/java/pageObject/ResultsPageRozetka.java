package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @FindBy(css = ".catalog-settings__sorting")
    private WebElement sort;
    @FindBy(css = ".promo-label_type_novelty")
    private WebElement novelty;
    @FindBy(css = ".promo-label_type_popularity")
    private WebElement popularity;
    @FindBy(css=".promo-label_type_action")
    private WebElement action;
    String prices = "//span[@class='goods-tile__price-value']";


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

    public ResultsPageRozetka settingsSort(String value){
        sort.click();
        WebElement listBox = driver.findElement(By.xpath("//select"));
        Select select = new Select(listBox);
        select.selectByValue(value);
        this.sleep(1);
        return this;
    }

    public void checkPricesAsc() {
        List<WebElement> pricesList = driver.findElements(By.xpath(prices));
        int[] arr = integerValues(pricesList);
        for(int i = 0; i<arr.length-1; i++){
            if(!(arr[i]<=arr[i+1])) {
                try {
                    throw new Exception("Not ascending!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void checkPricesDesc()  {
        List<WebElement> pricesList = driver.findElements(By.xpath(prices));
        int[] arr = integerValues(pricesList);
        for(int i = 0; i<arr.length-1; i++){
            if(!(arr[i]>=arr[i+1])) {
                try {
                    throw new Exception("Not descending!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void checkNovelty(){
        if(!novelty.isDisplayed()){
            try {
                throw new Exception("No new products!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkPopularity(){
        if(!popularity.isDisplayed()){
            try {
                throw new Exception("No popular products!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkAction(){
        if(!action.isDisplayed()){
            try {
                throw new Exception("No action products!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}