package oracle_java_certification;

import java.math.BigDecimal;

public class DataTypesDemo {

    public static void main(String[] args) {
        // Example 1
        long a = 123451234512345L;
        System.out.println(a);
        // Example 2
        short b = 42;
        System.out.println(b);
        // Example 3
        int c = 0x2A;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(42));
        // Example 4
        int d = 052;
        System.out.println(d);
        // Example 5
        float e = 1.23451234512345f;
        System.out.println(e);
        // Example 6
        double f = 1.23451234512345;
        System.out.println(f);
        // Example 7
        double g = 0.02;
        System.out.println(g);
        System.out.println(new BigDecimal(g));
        // Example 8
        double h = 1.666656494140625;
        System.out.println(h);
        System.out.println(new BigDecimal(h));
        // Example 9
        char ac = 'a';
        char bc = 97;
        char cc = 0x03C0;
        char dc = '\u03C0';
        System.out.println(ac);
        System.out.println(bc);
        System.out.println(cc);
        System.out.println(dc);
        System.out.println(ac + bc + cc + dc);
        // Example 10
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println('0' + Integer.toBinaryString(max));
        max = Integer.MAX_VALUE + 1;
        System.out.println(max);
        System.out.println(Integer.toBinaryString(max));
        // Example 11
        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(Integer.toBinaryString(min));
        int too_small = min - 1;
        System.out.println(too_small);
        System.out.println('0' + Integer.toBinaryString(too_small));
        // Example 12
        double sum = 0;
        for (int i = 0; i < 50; i++) sum += 0.02;
        System.out.println(sum);
    }

}
