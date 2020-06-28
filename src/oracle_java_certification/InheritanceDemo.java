package oracle_java_certification;

import oracle_java_certification.package1.ClassA;
import oracle_java_certification.package2.ClassB;

import javax.swing.plaf.IconUIResource;

public class InheritanceDemo extends Example {

    private String message = "Hello!";

    public InheritanceDemo() {
//        super.message2 = "Hello";
        super("Hello");
    }

    public InheritanceDemo(String message3) {
        super(message3);
    }

    public static void main(String[] args) {
        // Example 1
        new InheritanceDemo().print();
        new ClassA().print();
        new ClassB().print();
        // Example 2
        InheritanceDemo i = new InheritanceDemo();
        InheritanceDemo2 i2 = new InheritanceDemo2();
        System.out.println(i.message);
        System.out.println(i2.message());
        // Example 3
        System.out.println(i.message2());
        System.out.println(i2.message2());
        // Example 4
        i.print3();
        i2.print3();
        // Example 5
        i.print4();
        i2.print4();
        // Example 6
        System.out.println(new InheritanceDemo().message2);
        // Example 7
        System.out.println(new InheritanceDemo("Hello"));
    }

    private void print() {
        System.out.println(message);
    }

    void print3() {
        System.out.println(message3());
    }

    void print4() {
        System.out.println(message4());
    }

    Object message() {
        return "Hello!";
    }

    static Object message2() {
        return "Hello!";
    }

    private String message3() {
        return "Hello!";
    }

    protected String message4() {
        return "Hello!";
    }

    public String toString() {
        return super.toString() + "!";
    }

}
