import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePageRozetka;
import pageObject.ResultsPageRozetka;

public class AddingToCartTest extends BasePage {

    @Test
    public void addProductToCart() {
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.goToResultsPage();
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.goToProductPage()
                .clickToCheckout();
    }
}
