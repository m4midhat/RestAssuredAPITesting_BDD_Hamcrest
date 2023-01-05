import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getRequests {

    @Test
    public void getCityWeather(){
        given()
                .when()
                    .get("https://demoqa.com/utilities/weather/city/lahore")
                .then()
                .statusCode(200)
                .assertThat().body("City", equalTo("lahore"))
                .assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
                .log().all();
    }

}
