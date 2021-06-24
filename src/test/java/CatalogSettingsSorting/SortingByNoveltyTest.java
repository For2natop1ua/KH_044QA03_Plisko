package CatalogSettingsSorting;

import Task5.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class SortingByNoveltyTest extends BaseTest {

    @Test(groups = "sorting")
    public void sortingByNoveltyTest() {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.settingsSort("4: novelty");
        Assert.assertTrue(resultsPageRozetka.getNovelty().isDisplayed());
    }
}