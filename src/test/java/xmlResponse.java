import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class xmlResponse {

    private String customerID="5";
    @Test
    public void verifyXMLContent(){

        given()
                .when()
                    .get("http://thomas-bayer.com/sqlrest/CUSTOMER/"+customerID)
                .then()
                .body("CUSTOMER.ID", equalTo(customerID))
                .body("CUSTOMER.FIRSTNAME", equalTo("Laura"))
                .body("CUSTOMER.LASTNAME", equalTo("Miller"))
                .body("CUSTOMER.STREET", equalTo("294 Seventh Av."))
                .body("CUSTOMER.CITY", equalTo("Paris"))
                .log().all();
    }

    @Test
    public void verifyXMLCompleteContents(){

        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/"+customerID)
                .then()
                .body("CUSTOMER.text()", equalTo(customerID+"LauraMiller294 Seventh Av.Paris"))
                .log().all();
    }

    @Test
    public void verifyXmlWithXpath(){

        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/"+customerID)
                .then()
                .body(hasXPath("/CUSTOMER/ID", equalTo(customerID)))
                .body(hasXPath("/CUSTOMER/FIRSTNAME", equalTo("Laura")))
                .body(hasXPath("/CUSTOMER/STREET", containsString("Av.")))
                .log().all();
    }


    @Test
    public void verifyXmlWithXpathFunction(){

        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE")
                .then()
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
                .log().all();
    }

}
