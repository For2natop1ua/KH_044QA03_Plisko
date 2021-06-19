package RestAPITests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetSingleUserResourceTest {

    @Test
    public void getSingleUserResourceTest(){
        Response response = given().when().get("https://reqres.in/api/unknown/2");
        File jsonSchema = new File("src/test/resources/schemas/getSingleUserResource.json");
        response
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(jsonSchema));
        System.out.println("getSingleUserResourceTest Status Code is: " + response.statusCode());
    }
}