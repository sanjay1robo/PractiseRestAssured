import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;

// Multiple ways of handling path parameters :

// 1. By Passing path param one by one

public class HandlingPathParameters {

    public static void main (String args[])
    {
        RestAssured.given()
                            .log().all()
                            .baseUri("https://restful-booker.herokuapp.com/")
                            .basePath("{addressPath}/{id}")
                            .pathParam("addressPath","booking")
                            .pathParam("id",1256)
                            .contentType(ContentType.JSON)
                .when()
                            .get()
                    .then()
                            .log().all()
                            .statusCode(200);

        System.out.println("=========================================");

        // 2. By Passing path param as a map

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("addressPath","booking");
        hmap.put("id",1256);

        RestAssured.given()
                        .log().all()
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("{addressPath}/{id}")
                        .pathParams(hmap)
                    .when()
                        .get()
                    .then()
                        .log().all()
                        .statusCode(200);


    }

}
