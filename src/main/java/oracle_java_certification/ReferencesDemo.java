package oracle_java_certification;

public class ReferencesDemo {

    static Integer a;
    int a7 = 123;
    public Integer a8;

    public ReferencesDemo() {
        a8 = 3;
        System.out.println("Constructor: " + a8);
    }

    {
        a8 = 2;
        System.out.println("Initializer: " + a8);
    }

    public void finalize() {
        System.out.println("Bye from: " + this);
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(a);
        // Example 2
        Integer b = null;
        System.out.println(b);
        // Example 3
        int a1 = 123;
        Integer b1 = new Integer(a1);
        Integer c1 = new Integer(("123"));
        Integer d1 = Integer.parseInt("123");
        Integer e1 = a1;
        System.out.println(a1 + " " + b1);
        System.out.println(c1 + " " + d1 + " " + e1);
        // Example 4
        char a2 = 'a';
        int b2 = a2;
        System.out.println(a2);
        System.out.println(b2);
        // Example 5
        byte b3 = (byte) 261;
        System.out.println(b3);
        System.out.println(Integer.toBinaryString(b3));
        System.out.println(Integer.toBinaryString(261));
        // Example 6
        int a4 = (int) 12.3;
        System.out.println(a4);
        // Example 7
//        int a5=(int)true;
//        boolean b5=(boolean)1;
//        System.out.println(a5+b5);
        // Example 8
        Integer a6 = 123;
        Object b6 = a6;
        System.out.println(a6);
        a6 = (Integer) b6;
        System.out.println(b6 instanceof Integer);
        System.out.println(a6);
        // Example 9
        ReferencesDemo r = new ReferencesDemo();
        r.print();
        r.print1(234);
        r.print();
        // Example 10
        System.out.println(new ReferencesDemo().a8);
        // Example 11
        r = new ReferencesDemo();
        ReferencesDemo r2 = r;
        System.out.println("r: " + r);
        r = null;
        System.out.println("r2: " + r2);
        r2 = null;
        System.gc();
        System.out.println("End of main()");
    }

    public void print() {
        System.out.println(a7);
    }

    public void print1(int a7) {
        System.out.println(a7);
        a7 = 345;
    }

}
