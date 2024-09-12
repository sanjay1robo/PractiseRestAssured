import Utility.UtilityMethods;

import static Utility.UtilityMethods.printMsg;
import static Utility.UtilityMethods.add;
import static Utility.UtilityMethods.salary;

public class Usage {

    public static void main (String args[])
    {
        printMsg();
        int sum = add(1,2);
        System.out.println(sum);
        System.out.println(salary);
    }
}

// We can static import variables and methods both