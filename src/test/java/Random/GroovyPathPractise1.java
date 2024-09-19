package Random;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Optional;

public class GroovyPathPractise1 {

//    product.id is 54321.
//    product.name is "Laptop".
//    product.price is 999.99.
//    The first review's comment is "Excellent product!".


    public static void main (String args[])
    {
        String jsonString = "{\n" +
                "  \"product\": {\n" +
                "    \"id\": 54321,\n" +
                "    \"name\": \"Laptop\",\n" +
                "    \"price\": 999.99,\n" +
                "    \"inStock\": true,\n" +
                "    \"tags\": [\"electronics\", \"computers\"]\n" +
                "  },\n" +
                "  \"reviews\": [\n" +
                "    {\n" +
                "      \"reviewId\": 1,\n" +
                "      \"rating\": 5,\n" +
                "      \"comment\": \"Excellent product!\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"reviewId\": 2,\n" +
                "      \"rating\": 4,\n" +
                "      \"comment\": \"Good value for money.\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";


        JsonPath jsonPath = new JsonPath(jsonString);
        System.out.println(Optional.ofNullable(jsonPath.get()));

        Assert.assertEquals(jsonPath.getString("product.id"),"5432","Product id is wrong");
        Assert.assertEquals(jsonPath.getString("product.name"),"Laptop");
        Assert.assertEquals(jsonPath.getString("product.price"),"999.99");
        Assert.assertEquals(jsonPath.getString("reviews[0].comment"),"Excellent product!");
    }
}
