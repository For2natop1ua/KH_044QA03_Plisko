package RestAPITests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetSingleUserTest {

    @Test
    public  void getSingleUserTest(){
        File jsonSchema = new File("src/test/resources/schemas/getSingleUser.json");
        Response response = given()
                .when().get("https://reqres.in/api/users/2");
        response.then().statusCode(200).assertThat().body(matchesJsonSchema(jsonSchema));
        System.out.println("getSingleUserTest Status Code is: " + response.statusCode());
    }
}