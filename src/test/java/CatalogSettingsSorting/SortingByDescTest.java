package CatalogSettingsSorting;

import Task5.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class SortingByDescTest extends BaseTest {

    @Test(groups = "sorting")
    public void sortingByDescTest() {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.settingsSort("2: expensive");
        int[] arrExpensive = resultsPageRozetka.getPrices();
        for (int i = 0; i < arrExpensive.length - 1; i++) {
            Assert.assertTrue(arrExpensive[i] >= arrExpensive[i + 1]);
        }
    }
}