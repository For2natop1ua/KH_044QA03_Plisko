package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ResultsPageRozetka extends BasePage {

    @FindBy(css = "a.goods-tile__picture")
    private By searchResults;
    @FindBy(xpath = "//a[@href='/monitors/c80089/seller=rozetka/']")
    private WebElement rozetkaSeller;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;
    @FindBy(css = "rz-lazy.app-footer")
    private WebElement footer;
    @FindBy(xpath = "//input[@formcontrolname = 'min']")
    private WebElement minPrice;
    @FindBy(xpath = "//input[@formcontrolname = 'max']")
    private WebElement maxPrice;
    @FindBy(css = ".button.slider-filter__button")
    private WebElement buttonPriceOk;
    @FindBy(css = ".catalog-settings__sorting")
    private WebElement sort;
    @FindBy(css = ".promo-label_type_novelty")
    private WebElement novelty;
    @FindBy(css = ".promo-label_type_popularity")
    private WebElement popularity;
    @FindBy(css = ".promo-label_type_action")
    private WebElement action;
    @FindBy(css = ".catalog-grid.ng-star-inserted")
    private WebElement catalog;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<WebElement> pricesList;

    public ResultsPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForClickable(resultsGrid);
    }

    public ResultsPageGoogle moveToFooter() {
        newAction().moveToElement(footer);
        return new ResultsPageGoogle(driver);
    }

    public ResultsPageRozetka chooseSellerRozetka(){
        rozetkaSeller.click();
        waitForVisibility(catalogSettings);
        return this;
    }

    public ProductPageRozetka openFirstProductPage() {
        List<WebElement> results = driver.findElements(searchResults);
        results.get(0).click();
        return new ProductPageRozetka(driver);
    }

    public WebElement getButtonPriceOk(){
        return buttonPriceOk;
    }

    public WebElement getNovelty(){
        return novelty;
    }

    public WebElement getPopularity(){
        return popularity;
    }

    public WebElement getAction(){
        return action;
    }

    public int[] getPrices() {
        waitForRedrawn(pricesList.get(0));
        String[] str = new String[10];
        int size = str.length;
        for(int i = 0;i<size;i++){
            str[i] = pricesList.get(i).getText().replace(" ", "");
        }
        int[] pricesArr = new int [size];
        for(int i =0; i<size; i++){
            pricesArr[i] = Integer.parseInt(str[i]);
        }
        return pricesArr;
    }

    public void inputFields(String min, String max){
        minPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.clear();
        maxPrice.sendKeys(max);
    }

    public void settingsSort(String value){
        sort.click();
        WebElement listBox = driver.findElement(By.xpath("//select"));
        Select select = new Select(listBox);
        try {
            select.selectByValue(value);
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
}