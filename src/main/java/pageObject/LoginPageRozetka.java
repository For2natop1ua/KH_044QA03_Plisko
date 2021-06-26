package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRozetka extends BasePage{

    @FindBy(css = ".auth-modal__register-link.ng-star-inserted")
    private WebElement registerButton;

    public LoginPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPageRozetka goToRegister(){
        waitForClickable(registerButton);
        registerButton.click();
        return new RegisterPageRozetka(driver);
    }
}
