package oracle_java_certification;

import java.util.ArrayList;

public class AbstractAndInterfaceDemo extends Example2 implements MainInterface {

    public static void main(String[] args) {
        // Example 1
        System.out.println(new AbstractAndInterfaceDemo().message());
        MainInterface.print();
        new AbstractAndInterfaceDemo().print2();
        // Example 2
        AbstractAndInterfaceDemo a = new AbstractAndInterfaceDemo();
        Example2 e;
        e = a;
        a = (AbstractAndInterfaceDemo) e;
        a.print3();
        // Example 3
        final ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add("World");
        array.add("!");
        System.out.println(array);
    }

    public void print2() {
        System.out.println("Hello!");
    }

    public void print3() {
        System.out.println("World");
    }

//    String message() {
//        return "World!";
//    }

}
