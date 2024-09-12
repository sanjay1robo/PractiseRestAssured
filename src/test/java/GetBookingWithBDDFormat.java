import io.restassured.RestAssured;

// NOTE : The usage of path parameter in this case

public class GetBookingWithBDDFormat {

    public static void main (String args[])
    {
            RestAssured.given()
                            .log().all()
                            .baseUri("https://restful-booker.herokuapp.com")
                            .basePath("booking/{id}")
                            .pathParam("id",1255)
                        .when()
                            .get()
                        .then()
                            .log().all()
                            .statusCode(200);


    }
}
