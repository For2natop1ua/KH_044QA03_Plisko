package Task5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.ResultsPageRozetka;

public class PriceFieldValidationTest extends BaseTest{

    @DataProvider(name = "IncorrectInput")
    public static Object[][]  priceDataIncorrect() {
        return new Object[][]{
                {"a", "q"},
                {"$", "#"},
                {"!", "500"},
                {"1000", "-1500"},
        };
    }

    @DataProvider(name = "CorrectInput")
    public static Object[][]  priceDataCorrect() {
        return new Object[][]{
                {"300", "2000"},
                {"500", "501"},
                {"1000", "99999"}
        };
    }

    @Test(groups = "sorting", dataProvider = "IncorrectInput")
    public void verifyIncorrectField(String min, String max) {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);

        resultsPageRozetka
                .inputFields(min, max);

        Assert.assertFalse(resultsPageRozetka.getButtonPriceOk().isEnabled());
    }

    @Test(groups = "sorting", dataProvider = "CorrectInput")
    public void verifyCorrectField(String min, String max) {
        ResultsPageRozetka resultsPageRozetka = new ResultsPageRozetka(driver);

        resultsPageRozetka
                .inputFields(min, max);

        Assert.assertTrue(resultsPageRozetka.getButtonPriceOk().isEnabled());
    }
}