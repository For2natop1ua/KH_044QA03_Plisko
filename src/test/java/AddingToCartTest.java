import org.testng.annotations.Test;
import pageObject.HomePageRozetka;
import pageObject.ResultsPageRozetka;

public class AddingToCartTest extends BaseTest {

    @Test
    public void addProductToCart() {
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.goToResultsPage();
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.openFirstProductPage()
                .clickToCheckout();
    }
}