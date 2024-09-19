package Random;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class GroovyPathPractise3 {

//        Validate that:
//        user.id is 67890.
//        user.name is "Jane Smith".
//            user.address.city is "Somewhere".
//            The subscriptions array contains an active newsletter subscription.


    public static void main (String args[])
    {
            String jsonString = "{\n" +
                "  \"user\": {\n" +
                "    \"id\": 67890,\n" +
                "    \"name\": \"Jane Smith\",\n" +
                "    \"age\": 30,\n" +
                "    \"address\": {\n" +
                "      \"street\": \"123 Elm St\",\n" +
                "      \"city\": \"Somewhere\",\n" +
                "      \"postalCode\": \"12345\"\n" +
                "    },\n" +
                "    \"subscriptions\": [\n" +
                "      {\"type\": \"newsletter\", \"active\": true},\n" +
                "      {\"type\": \"promotions\", \"active\": false}\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";



            JsonPath jsonPath = new JsonPath(jsonString);

            Assert.assertEquals(jsonPath.getInt("user.id"),67890);
            Assert.assertEquals(jsonPath.getString("user.name"),"Jane Smith");
            Assert.assertEquals(jsonPath.getString("user.address.city"),"Somewhere");


//            int activeSubscriptionCount = 0;
//
//            for(Subscription subscription : subscriptionList)
//            {
//                if(subscription.getActive())
//                {
//                    activeSubscriptionCount++;
//                }
//            }
//
//            Assert.assertTrue(activeSubscriptionCount>=1,"Not even one active subscription found");

              //Boolean value = jsonPath.getBoolean("user.subscriptions.find { it.type == \"newsletter\" }.active)");
              // Assert.assertEquals("jsonPath.getBoolean("user.subscriptions.find{ it.type == \"newsletter\" }.active)", true);


       // System.out.println(value);


        boolean b = jsonPath.getList("user.subscriptions.findAll { it.type == 'newsletter' && it.active }").size() > 0;

        System.out.println(b);


    }
}
