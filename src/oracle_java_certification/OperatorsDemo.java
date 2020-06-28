package oracle_java_certification;

public class OperatorsDemo {

    public static void main(String[] args) {
        // Example 1
        int a = -42;
        System.out.println(+a);
        System.out.println(-a);
        System.out.println(a);
        // Example 2
        int b = 42;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(~b));
        // Example 3
        System.out.println(++b);
        System.out.println(b);
        System.out.println(b++);
        System.out.println(b);
        System.out.println(--b);
        System.out.println(b);
        // Example 4
        System.out.println(1 << 1);
        System.out.println(-1 << 1);
        System.out.println(4 >> 1);
        System.out.println(-4 >> 1);
        System.out.println(1 >> 1);
        System.out.println(-4 >>> 1);
        // Example 5
        System.out.println(5 % 3);
        System.out.println(-5 % -3);
        System.out.println(-5 % 3);
        System.out.println(5 % -3);
        // Example 6
        System.out.println(1 & 2);
        System.out.println(1 & 3);
        System.out.println(1 | 3);
        System.out.println(1 ^ 3);
        // Example 7
        System.out.println(true & true);
        System.out.println(true & false);
        System.out.println(false & false);
        System.out.println(true | true);
        System.out.println(true | false);
        System.out.println(false | false);
        // Example 8
        System.out.println(true && true);
        System.out.println(false && 1 / 0 == 1);
        System.out.println(true || false || 1 / 0 == 1);
        // Example 9
        int c = 1;
        System.out.println(3 + 2 * ++c);
        // Example 10
        c = 1;
        System.out.println(a = b = c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        // Example 11
        System.out.println(true ? 1 : (false ? 2 : (true ? 1 / 0 : 3)));
    }

}
