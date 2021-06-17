package Task5;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

import java.util.List;

import static pageObject.ResultsPageRozetka.convertPricesToInt;

public class CatalogSettingsSortingTest extends BaseTest {

    @Test(groups = "sorting")
    public void checkSorting(){
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);

        resultsPageRozetka.settingsSort("1: cheap");
        List<WebElement> cheapPricesList = resultsPageRozetka.getPrices();
        int[] arrCheap = convertPricesToInt(cheapPricesList);
        for (int i = 0; i < arrCheap.length - 1; i++) {
            Assert.assertTrue(arrCheap[i] <= arrCheap[i + 1]);
        }

        resultsPageRozetka.settingsSort("2: expensive");
        List<WebElement> expensivePricesList = resultsPageRozetka.getPrices();
        int[] arrExpensive = convertPricesToInt(expensivePricesList);
        for (int i = 0; i < arrExpensive.length - 1; i++) {
            Assert.assertTrue(arrExpensive[i] >= arrExpensive[i + 1]);
        }

        resultsPageRozetka.settingsSort("3: popularity");
        Assert.assertTrue(resultsPageRozetka.getPopularity().isDisplayed());

        resultsPageRozetka.settingsSort("4: novelty");
        Assert.assertTrue(resultsPageRozetka.getNovelty().isDisplayed());

        resultsPageRozetka.settingsSort("5: action");
        Assert.assertTrue(resultsPageRozetka.getAction().isDisplayed());
    }
}
