import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;

public class UpdateBookingPUT {

    public static void main(String args[])
    {

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("booking","booking");
        hmap.put("id",1);

            RestAssured.given()
                        .log().all()
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("{booking}/{id}")
                        .pathParams(hmap)
                        .header("Content-Type",ContentType.JSON)
                        .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body("{\n" +
                            "    \"firstname\" : \"James\",\n" +
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
                        .put()
                    .then()
                        .log().all()
                        .statusCode(200);
    }

}
