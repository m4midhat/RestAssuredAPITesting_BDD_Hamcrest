import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteRequests {

    @Test
    public void deleteEmployee(){

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/2";

        Response jsonResponse =
                (Response) given()
                        .when()
                            .delete()
                        .then()
                            .statusCode(200)
                            .statusLine("HTTP/1.1 200 OK")
                        .log().all()
                        .extract().response();
        String responseStr = jsonResponse.asString();
        Assert.assertTrue(responseStr.contains("Successfully! Record has been deleted"));
    }

}
