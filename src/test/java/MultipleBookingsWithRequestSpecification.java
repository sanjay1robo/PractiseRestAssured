import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MultipleBookingsWithRequestSpecification {

    RequestSpecification commonRequestSpecification ;
    ResponseSpecification commonResponseSpecification;

    @BeforeClass
    public void setUpRequestSpecification()
    {
        commonRequestSpecification = RestAssured.given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/")
                .contentType(ContentType.JSON);

    }

    @BeforeClass
    public void setUpResponsepecification()
    {
        commonResponseSpecification = RestAssured.expect();
        commonResponseSpecification.log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(5000L));
    }

    // Using TestNG

    @Test

    public void MakeBooking ()
    {
        RequestSpecification requestSpecification = RestAssured.given()
                .spec(commonRequestSpecification)
                .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}"
                );

        Response response = requestSpecification.post();
        ValidatableResponse validatableResponse =
                response.then()
                        .spec(commonResponseSpecification);

    }

    @Test
    public void UpdateBooking ()
    {

        System.out.println("++++++++++++++++++++++++++++++++++");

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("id", 1251);

        RestAssured.given()
                .spec(commonRequestSpecification)
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .basePath("/booking/{id}")
                .pathParams(hmap)
                .body("{\n" +
                        "    \"firstname\" : \"Juno1\",\n" +
                        "    \"lastname\" : \"Brown\"\n" +
                        "}")
                .when()
                .patch()
                .then()
                .spec(commonResponseSpecification);
    }
}

// The basePath provided directly in the request
// will override any basePath set in the request specification.
// As per my understanding => Sanjay