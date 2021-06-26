package CatalogSettingsSorting;

import Task5.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class SortingByAscTest extends BaseTest {

    @Test(groups = "sorting")
    public void sortingByAscTest() {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.settingsSort("1: cheap");
        int[] arrCheap = resultsPageRozetka.getPrices();
        for (int i = 0; i < arrCheap.length - 1; i++) {
            Assert.assertTrue(arrCheap[i] <= arrCheap[i + 1]);
        }
    }
}