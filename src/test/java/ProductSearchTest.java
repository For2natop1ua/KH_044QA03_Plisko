import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.HomePageGoogle;
import pageObject.HomePageRozetka;

import java.util.concurrent.TimeUnit;

public class ProductSearchTest {
    WebDriver driver;

    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test
    public void searchProduct() {
        HomePageGoogle homePageGoogle = new HomePageGoogle(driver);
        homePageGoogle
                .goToResultsPage()
                .clickFirstResult();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://rozetka.com.ua/");

        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka
                .goToResultsPage()
                .moveToFooter();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}