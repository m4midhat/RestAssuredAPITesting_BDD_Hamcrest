import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void getCityWeatherAndVerifyJSonPathData(){
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void getCountriesAndVerifyMultipleItems(){
        given()
                .header("contentType", "application/json")
                .param("parameter1", "value1")
        .when()
                .get("https://restcountries.com/v3.1/all")
                .then()
                .statusCode(200)
                .body("name.official",
                        hasItems(
                                "Islamic Republic of Pakistan",
                                "Republic of Singapore",
                                "Islamic Republic of Mauritania",
                                "Republic of Poland",
                                "Republic of Chad",
                                "Lebanese Republic"
                                )
                    );
    }

}
