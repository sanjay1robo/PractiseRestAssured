package Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionPractise {

    public static void main (String args[])
    {
        String str = "user@name";

        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{3,12}$");
        Matcher matcher = pattern.matcher(str);
        Boolean matchFound = matcher.find();

        if(matchFound)
        {
            System.out.println("Valid username");
        }
        else
        {
            System.out.println("Invalid username");
        }

    }
}
