package Task5;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePageRozetka;
import pageObject.ResultsPageRozetka;

import java.util.List;

public class CatalogSettingsSortingTest extends BaseTest{

    @DataProvider(name = "ItemValue")
    public static Object[][]  productValue() {
        return new Object[][]{
                {"1: cheap"},
                {"2: expensive"},
                {"3: popularity"},
                {"4: novelty"},
                {"5: action"}
        };
    }

    @Test(groups = "sorting", dataProvider = "ItemValue")
    public void valueFilter(String value) {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);

        homePageRozetka
                .chooseMonitorFromCatalog()
                .settingsSort(value);

        switch (value) {
            case "1: cheap":
                List<WebElement> cheapPricesList = resultsPageRozetka.getPrices();
                int[] arrCheap = integerValues(cheapPricesList);
                for (int i = 0; i < arrCheap.length - 1; i++) {
                    if (!(arrCheap[i] <= arrCheap[i + 1])) {
                        try {
                            throw new Exception("Not ascending!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "2: expensive":
                List<WebElement> expensivePricesList = resultsPageRozetka.getPrices();
                int[] arrExpensive = integerValues(expensivePricesList);
                for (int i = 0; i < arrExpensive.length - 1; i++) {
                    if (!(arrExpensive[i] >= arrExpensive[i + 1])) {
                        try {
                            throw new Exception("Not descending!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "3: popularity":
                if (!resultsPageRozetka.getPopularity().isDisplayed()) {
                    try {
                        throw new Exception("No popular products!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "4: novelty":
                if (!resultsPageRozetka.getNovelty().isDisplayed()) {
                    try {
                        throw new Exception("No new products!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "5: action":
                if (!resultsPageRozetka.getAction().isDisplayed()) {
                    try {
                        throw new Exception("No action products!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    private static int[] integerValues(List<WebElement> pricesList){
        String[] str = new String[10];
        int size = str.length;
        for(int i = 0;i<size;i++){
            str[i] = pricesList.get(i).getText().replace(" ", "");
        }
        int[] arr = new int [size];
        for(int i =0; i<size; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
}