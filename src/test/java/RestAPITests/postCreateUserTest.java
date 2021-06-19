package RestAPITests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class postCreateUserTest {

    @Test
    public void postCreateUserTest(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        File jsonCreateUser = new File("src/test/resources/schemas/postCreateUser.json");
        System.out.println("postCreateUserTest body is: ");
        RestAssured.given().body(jsonCreateUser).post().then().log().body().statusCode(201);
    }
}
