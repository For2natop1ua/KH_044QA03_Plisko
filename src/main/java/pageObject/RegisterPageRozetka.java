package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPageRozetka extends BasePage{

    @FindBy(id = "registerUserName")
    private WebElement userName;
    @FindBy(id = "registerUserSurname")
    private WebElement userSurname;
    @FindBy(id = "registerUserPhone")
    private WebElement userPhone;
    @FindBy(id = "registerUserEmail")
    private WebElement userEmail;
    @FindBy(id = "registerUserPassword")
    private WebElement userPassword;
    @FindBy(css = ".validation-message.ng-star-inserted")
    private WebElement validationMsg;

    public RegisterPageRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPageRozetka incorrectAuth(){
        userName.sendKeys("Zelenoglazoe");
        userSurname.sendKeys("Taksi");
        userPhone.sendKeys("pritormozi");
        userEmail.sendKeys("pritormoziii");
        userPassword.sendKeys("qwerty-azerty");
        Assert.assertTrue(validationMsg.isDisplayed());
        return this;
    }

}
