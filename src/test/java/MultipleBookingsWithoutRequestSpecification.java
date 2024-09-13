import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MultipleBookingsWithoutRequestSpecification {


    // Using TestNG

    @Test

    public void MakeBooking ()
    {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body("{\n" +
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
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test
    public void UpdateBooking ()
    {

        System.out.println("++++++++++++++++++++++++++++++++++");

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("id", 1251);

        RestAssured.given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}")
                .contentType(ContentType.JSON)

                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .pathParams(hmap)
                .body("{\n" +
                        "    \"firstname\" : \"Juno1\",\n" +
                        "    \"lastname\" : \"Brown\"\n" +
                        "}")
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200);
    }
}
