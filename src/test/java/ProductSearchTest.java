import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePageRozetka;

public class ProductSearchTest extends BasePage {

    @Test
    public void searchProduct() {

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://rozetka.com.ua/");

        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka
                .goToResultsPage()
                .moveToFooter();
    }
}