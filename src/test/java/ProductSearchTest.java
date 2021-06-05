import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePageGoogle;

import java.util.concurrent.TimeUnit;

public class ProductSearchTest extends BasePage {

    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void searchProduct() {
        HomePageGoogle homePageGoogle = new HomePageGoogle(driver);
        homePageGoogle.openPage()
                .goToResultsPage()
                .clickFirstResult()
                .verifyLink()
                .goToResultsPage()
                .moveToFooter();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}