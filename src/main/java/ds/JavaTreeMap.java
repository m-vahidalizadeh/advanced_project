package ds;

import java.util.TreeMap;

public class JavaTreeMap {

    public static void main(String[] args) {
        TreeMap<Character, Integer> tm = new TreeMap<>();
        tm.put('a', 5);
        tm.put('c', 15);
        tm.put('g', 50);
        tm.put('i', 2);
        tm.put('o', 11);
        tm.put('w', 13);
        tm.put('z', 3);
        System.out.println(tm.firstEntry()); // a
        System.out.println(tm.lastEntry()); // z
        System.out.println(tm.ceilingEntry('a')); // a
        System.out.println(tm.ceilingEntry('b')); // c
        System.out.println(tm.floorEntry('z')); // z
        System.out.println(tm.floorEntry('y')); // w
        System.out.println(tm.lowerEntry('c')); // a
        System.out.println(tm.higherEntry('x')); // z
    }

}
