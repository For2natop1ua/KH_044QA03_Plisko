package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPageRozetka extends BasePage {

    @FindBy(css = "rz-lazy.app-footer")
    private WebElement footer;

    public ResultsPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultsPageGoogle moveToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        return new ResultsPageGoogle(driver);
    }
}