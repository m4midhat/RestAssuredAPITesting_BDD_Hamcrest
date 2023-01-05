import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postRequests {

    public static HashMap map = new HashMap<>();

    @BeforeClass
    public void generateTestData(){
        map.put("name", Utils.getFirstName());
        map.put("job", Utils.getJob());

        RestAssured.baseURI="https://reqres.in/api";
        RestAssured.basePath="/users";
    }

    @Test
    public void createUser(){
        given()
                    .contentType("application/json")
                    .body(map)
                .when()
                    .post()
                .then()
                    .statusCode(201)
                    .and()
                    .body("name", equalTo(map.get("name")))
                    .and()
                    .body("job", equalTo(map.get("job")))
                .log().all();

    }

}
