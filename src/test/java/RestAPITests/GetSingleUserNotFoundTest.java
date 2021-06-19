package RestAPITests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetSingleUserNotFoundTest {

    @Test
    public  void getSingleUserNotFoundTest(){
        Response response = given()
                .when().get("https://reqres.in/api/users/23");
        String jsonSchema = "{}";
        response.then().statusCode(404).assertThat().body(matchesJsonSchema(jsonSchema));
        System.out.println("getSingleUserNotFoundTest Status Code is: " + response.statusCode());
    }
}