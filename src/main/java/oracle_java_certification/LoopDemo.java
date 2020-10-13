package oracle_java_certification;

import java.util.List;

public class LoopDemo {

    public static void main(String[] args) {
        // Example 1
        int count = 0;
        while (count++ < 10) System.out.println("Hello world!");
        // Example 2
        count = 0;
        do {
            System.out.println("Hello world!");
        } while (++count < 10);
        // Example 3
        for (int i = 0; i < 5; i++) System.out.println("Hello world!");
        List<Character> list = List.of('A', 'B', 'C');
        for (Character c : list) System.out.println(c);
        // Example 4
        int[][] array = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        end1:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) break end1;
                System.out.println(array[i][j]);
            }
        }
        end2:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) continue end2;
                System.out.println(array[i][j]);
            }
        }
    }

}
