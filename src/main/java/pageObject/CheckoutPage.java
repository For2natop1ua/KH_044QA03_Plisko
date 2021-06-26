package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(css = "input.checkout-total__submit")
    private WebElement acceptButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        BasePage.logger.info("Going to Checkout page...");
        waitForClickable(acceptButton);
        BasePage.logger.info("Success!");
    }
}