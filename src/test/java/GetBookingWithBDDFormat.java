import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import org.json.JSONObject;

// NOTE : The usage of path parameter in this case

public class GetBookingWithBDDFormat {

    public static void main (String args[])
    {

//        JSONObject jsonObject = new JSONObject();
            String responseString = RestAssured.given()
                            .log().all()
                            .baseUri("https://restful-booker.herokuapp.com")
                            .basePath("booking/{id}")
                            .pathParam("id",1255)
                        .when()
                            .get()
                        .then()
                            .log().all()
                            .statusCode(200).extract().asString();


//            JSONObject jsonObject = new JSONObject(responseString);
//
//        System.out.println(jsonObject.getJSONArray());


    }
}
