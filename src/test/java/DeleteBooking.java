import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;

public class DeleteBooking {

    public static void main (String args[])
    {
        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("booking","booking");
        hmap.put("id",1255);

        RestAssured.given()
                        .log().all()
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("{booking}/{id}")
                        .contentType(ContentType.JSON)
                        .pathParams(hmap)
                        .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                        .delete()
                    .then()
                        .log().all()
                        .statusCode(201);
    }
}
