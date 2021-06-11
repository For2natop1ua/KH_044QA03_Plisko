import org.testng.annotations.Test;
import pageObject.HomePageRozetka;

public class OpenFirstMonitorTest extends BaseTest {

    @Test
    public void sellerFilterTest() {
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.chooseFromCatalog()
                .chooseSeller()
                .goToProductPage();
    }
}