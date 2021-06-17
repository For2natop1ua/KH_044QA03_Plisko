package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageRozetka extends BasePage {

    @FindBy(css = "input.search-form__input")
    private WebElement searchFieldRozetka;
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButtonSubmit;
    @FindBy(css = "button.menu__toggle")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;
    @FindBy(css = ".main-auth__button")
    private WebElement authButton;

    public HomePageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public ResultsPageRozetka chooseMonitorFromCatalog() {
        catalog.click();
        displaySection.click();
        return new ResultsPageRozetka(driver);
    }

    public ResultsPageRozetka searchProduct(String input) {
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys();
        searchButtonSubmit.click();
        return new ResultsPageRozetka(driver);
    }

    public LoginPageRozetka goToLoginPage(){
        waitForClickable(authButton);
        authButton.click();
        return new LoginPageRozetka(driver);
    }
}