package Task5;

import org.testng.annotations.Test;
import pageObject.HomePageRozetka;

public class FieldsRegistrationTest extends BaseTest{
    @Test(groups = "registration")
    public void incorrectInput(){
        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka
                .goToLoginPage()
                .goToRegister()
                .incorrectAuth("Vasya", "Pupkin","wasd", "azr", "qwerty-azerty");
    }
}