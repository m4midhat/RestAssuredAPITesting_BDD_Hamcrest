import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class putRequests {
    
    public static Map map = new HashMap();
    public static final int employeeID = 10;
    @BeforeClass
    public void generateTestData(){
        map.put("name", Utils.getFirstName());
        map.put("age", Utils.getAge());
        map.put("salary", Utils.getSalary());

        
        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/update/"+employeeID;
    }

    @Test
    public void testPutRequest(){
        given()
                .contentType("application/json")
                .body(map)
        .when()
                .put()
        .then()
                .statusCode(200)
                .body("message", equalTo("Successfully! Record has been updated."))
                .log().all();

    }
    
}
