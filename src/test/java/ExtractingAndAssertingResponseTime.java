import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExtractingAndAssertingResponseTime {

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

        System.out.println("++++++++++++++++++++++++");
        System.out.println("Time taken by an api : " + response.time()); // In milliseconds
        System.out.println("Time taken by an api : " + response.timeIn(TimeUnit.SECONDS)); // In seconds

        // Validating response time to be less than a value
        System.out.println("Validating response time :" + response.then().time(Matchers.lessThan(5000L)));

        // Validating response time to be in a range
        response.then().time(Matchers.both(Matchers.greaterThan(1000L)).and(Matchers.lessThan(5000L)));

        System.out.println("++++++++++++++++++++++++");
    }


}
