package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageRozetka extends BasePage {

    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(xpath = "a.goods-tile__picture")
    private WebElement products;
    @FindBy(css = "div.modal__holder")
    private WebElement modalPreloader;
    @FindBy(css = "span.buy-button__label")
    private WebElement buyButton;
    @FindBy(xpath = "//product-tab-main")
    private WebElement tabItemMain;
    @FindBy(css = "a.button_size_large")
    private WebElement acceptButton;

    public ProductPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForVisibility(tabItemMain);
    }

    public CheckoutPage clickToCheckout() {
        waitForClickable(buyButton);
        newAction().moveToElement(buyButton).perform();
        buyButton.click();
        waitForClickable(acceptButton);
        acceptButton.click();
        return new CheckoutPage(driver);
    }
}
