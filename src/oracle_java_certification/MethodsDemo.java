package oracle_java_certification;

public class MethodsDemo {

    private String message = "default";
//    static String message;
//    static final String message2;

    private MethodsDemo() {
    }

    private MethodsDemo(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        // Example 1
        int[] args1 = {1, 2, 3, 4};
        print("test 1", 1, 2, 3, 4);
        print("test 2", new int[]{1, 2, 3, 4});
        print("test 3", args1);
//        print("test 4",{1,2,3,4});
        // Example 2
        MethodsDemo m = new MethodsDemo();
        m.method1();
        m.method2();
//        m.method3();
        m.method4();
        // Example 3
        print(42);
        print(42L);
        // Example 4
        System.out.println(new MethodsDemo().message);
        // Example 5
        m.print();
        print();
        m = null;
        m.print();
        // Example 6
//        System.out.println(message);
//        System.out.println(message2);
        // Example 7
        String greetings = "Hello";
        update(greetings);
        System.out.println(greetings);
        StringBuilder greetings1 = new StringBuilder("Hello");
        update1(greetings1);
        System.out.println(greetings1);
    }

    static void print() {
        System.out.println("Hello!");
    }

    static void print(String label, int... data) {
        System.out.print(label + ":");
        for (int item : data) System.out.print(item);
        System.out.println();
    }

    static void print(Long num) {
        System.out.println(num);
    }

    static void print(Object obj) {
        System.out.println("object: " + obj);
    }

    public void method1() {
    }

    public void method2() {
        return;
    }

//    public Float method3(){
//        return 12.3;
//    }

    public Float method4() {
        return 12.3f;
    }

    static void update(String greetings) {
        greetings += "!";
    }

    static void update1(StringBuilder greetings) {
        greetings.append("!");
    }

}
