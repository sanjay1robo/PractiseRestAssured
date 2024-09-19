package Random;

class Parent
{
    int count = 1;

    void print()
    {
        System.out.println("This is a parent method");
    }

    static String str = "Parent";

    static void printStatic()
    {
        System.out.println("This is a static parent method");
    }

}

class Child extends Parent
{
    int count = 2;

    void print()
    {
        System.out.println("This is a child method");
    }

    static String str = "Child";

    static void printStatic()
    {
        System.out.println("This is a static child method");
    }
}


public class Launch {

    public static void main (String args[])
    {

        System.out.println("Using parent reference and parent object");
        Parent parent = new Parent();
        System.out.println(parent.count);
        parent.print();

        System.out.println("==========================================");

        System.out.println("Using child reference and child object");
        Child child = new Child();
        System.out.println(child.count);
        child.print();

        System.out.println("==========================================");

        System.out.println("Using parent reference and child object");
        System.out.println("PV-CM rule holds good here");
        Parent parent1 = new Child();
        System.out.println(parent1.count);
        parent1.print();

        System.out.println("==========================================");

        System.out.println("Using parent reference and child object but for static members");
        System.out.println("PV-PM rule");
        Parent parent2 = new Child();
        System.out.println(parent2.str);
        parent2.printStatic();

        System.out.println("==========================================");

        System.out.println("Using Child reference and child object but for static members");

        Child child1 = new Child();
        System.out.println(child1.str);
        child1.printStatic();


    }
}
