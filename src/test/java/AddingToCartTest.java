import org.testng.annotations.Test;
import pageObject.HomePageRozetka;
import pageObject.ResultsPageRozetka;

public class AddingToCartTest extends BaseTest {

    @Test
    public void addBookToCart() {
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.searchProduct("book");
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.openFirstProductPage()
                .clickToCheckout();
    }
}