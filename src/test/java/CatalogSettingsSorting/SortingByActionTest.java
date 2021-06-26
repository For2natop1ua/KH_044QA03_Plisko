package CatalogSettingsSorting;

import Task5.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class SortingByActionTest extends BaseTest {

    @Test(groups = "sorting")
    public void sortingByActionTest() {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        resultsPageRozetka.settingsSort("5: action");
        Assert.assertTrue(resultsPageRozetka.getAction().isDisplayed());
    }
}