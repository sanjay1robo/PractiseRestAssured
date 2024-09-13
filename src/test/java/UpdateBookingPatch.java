import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;

public class UpdateBookingPatch {

    public static void main (String args[])
    {

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("booking","booking");
        hmap.put("id", 1251);

            RestAssured.given()
                            .log().all()
                            .baseUri("https://restful-booker.herokuapp.com/")
                            .basePath("{booking}/{id}")
                            .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                            .contentType(ContentType.JSON)
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
