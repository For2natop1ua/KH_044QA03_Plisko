package CatalogSettingsSorting;

import Task5.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class SortingByPopularityTest extends BaseTest {

    @Test(groups = "sorting")
    public void sortingByPopularityTest() {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.settingsSort("3: popularity");
        Assert.assertTrue(resultsPageRozetka.getPopularity().isDisplayed());
    }
}