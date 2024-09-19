package Random;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.Optional;

public class GroovyPathPractise2 {

//    Validate that:
//    The total number of orders (totalOrders) is 2.
//    The first order's orderId is 98765.
//    The status of the second order is "pending".
//    The first order contains at least one item.
//
    public static void main (String args[])
    {
        String jsonString = "{\n" +
                "  \"orders\": [\n" +
                "    {\n" +
                "      \"orderId\": 98765,\n" +
                "      \"status\": \"shipped\",\n" +
                "      \"items\": [\n" +
                "        {\"itemId\": 1, \"quantity\": 2},\n" +
                "        {\"itemId\": 2, \"quantity\": 1}\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"orderId\": 98766,\n" +
                "      \"status\": \"pending\",\n" +
                "      \"items\": []\n" +
                "    }\n" +
                "  ],\n" +
                "  \"totalOrders\": 2\n" +
                "}\n";


            JsonPath jsonPath = new JsonPath(jsonString);
            Assert.assertEquals(jsonPath.getInt("totalOrders"),2);
            Assert.assertEquals(jsonPath.getInt("orders[0].orderId"),98765);
            Assert.assertEquals(jsonPath.getString(("orders[1].status")),"pending");
            Assert.assertTrue(jsonPath.getList("orders[0].items").size()>=1);


    }
}
