//import com.fasterxml.jackson.databind.util.JSONPObject;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.json.JSONObject;
//
//public class CreateBookingWithBDDFormat {
//
//    public static void main (String args[])
//    {
//
//        String responseString = RestAssured.given()
//                            .log().all()
//                            .baseUri("https://restful-booker.herokuapp.com/")
//                            .basePath("booking")
//                            .contentType(ContentType.JSON)
//                            .body("{\n" +
//                                "    \"firstname\" : \"Jim\",\n" +
//                                "    \"lastname\" : \"Brown\",\n" +
//                                "    \"totalprice\" : 111,\n" +
//                                "    \"depositpaid\" : true,\n" +
//                                "    \"bookingdates\" : {\n" +
//                                "        \"checkin\" : \"2018-01-01\",\n" +
//                                "        \"checkout\" : \"2019-01-01\"\n" +
//                                "    },\n" +
//                                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                                "}")
//                .when()
//                            .post()
//                .then()
//                            .log().all()
//                            .statusCode(200)
//                .extract().response().asString();
//
//        System.out.println("*********");
//      JSONObject jsonObject = new JSONObject(responseString);
//      String bookingInfo = jsonObject.getJSONObject("booking").toString(4);
//        System.out.println(bookingInfo);
//
//        System.out.println("*********");
//        System.out.println("Response handling through POJO");
//        JSONObject jsonObject = new JSONObject(responseString);
//        String bookingInfo = jsonObject.getJSONObject("booking").toString(4);
//        System.out.println(bookingInfo);
//
//    }
//}
