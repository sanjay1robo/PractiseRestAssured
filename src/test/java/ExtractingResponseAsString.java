import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractingResponseAsString {

    public static void main (String args[])
    {
        String responseString = RestAssured.given()
                        .log().all()
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("booking")
                        .contentType(ContentType.JSON)
                        .body("{\n" +
                                "    \"firstname\" : \"Jimmy\",\n" +
                                "    \"lastname\" : \"Brown\",\n" +
                                "    \"totalprice\" : 111,\n" +
                                "    \"depositpaid\" : true,\n" +
                                "    \"bookingdates\" : {\n" +
                                "        \"checkin\" : \"2018-01-01\",\n" +
                                "        \"checkout\" : \"2019-01-01\"\n" +
                                "    },\n" +
                                "    \"additionalneeds\" : \"Breakfast\"\n" +
                                "}")
                    .when()
                        .post()
                    .then()
                    .extract().response().asPrettyString();

        System.out.println(responseString);


    }
}
