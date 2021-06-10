import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePageRozetka;

public class OpenFirstMonitorTest extends BasePage {

    @Test
    public void sellerFilterTest() {
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.chooseFromCatalog()
                .chooseSeller()
                .goToProductPage();
    }
}