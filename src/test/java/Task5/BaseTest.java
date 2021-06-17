package Task5;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObject.HomePageGoogle;
import pageObject.HomePageRozetka;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(dependsOnMethods = "setUp", groups = {"registration", "sorting"})
    public void openRozetkaFromGoogle(){
        HomePageGoogle homePageGoogle = new HomePageGoogle(driver);
        homePageGoogle
                .search("rozetka")
                .clickFirstResult();
    }

    @BeforeMethod(dependsOnMethods = "openRozetkaFromGoogle", groups = "sorting")
    public void openProductPage(){
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka
                .chooseMonitorFromCatalog();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() +"["+ LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            finally {
                driver.quit();
            }
        }
        driver.quit();
    }
}
