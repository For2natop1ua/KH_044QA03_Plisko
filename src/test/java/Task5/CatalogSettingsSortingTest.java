package Task5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePageRozetka;
import pageObject.ResultsPageRozetka;

public class CatalogSettingsSortingTest extends BaseTest{

    @DataProvider(name = "ItemValue")
    public static Object[][]  productValue() {
        return new Object[][]{
                {"1: cheap"},
                {"2: expensive"},
                {"3: popularity"},
                {"4: novelty"},
                {"5: action"},
        };
    }

    @Test(groups = "sorting", dataProvider = "ItemValue")
    public void valueFilter(String value) {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);

        homePageRozetka
                .chooseFromCatalog()
                .settingsSort(value);

        switch (value){
            case "1: cheap":
                resultsPageRozetka.checkPricesAsc();
                break;
            case "2: expensive":
                resultsPageRozetka.checkPricesDesc();
                break;
            case "3: popularity":
                resultsPageRozetka.checkPopularity();
                break;
            case "4: novelty":
                resultsPageRozetka.checkNovelty();
                break;
            case "5: action":
                resultsPageRozetka.checkAction();
                break;
        }
    }
}