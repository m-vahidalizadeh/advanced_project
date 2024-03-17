package ds;

import java.util.Arrays;

public class JavaBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 12, 15, 34, 67, 89};
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 66));
        System.out.println(Arrays.binarySearch(arr, 89));
    }

}
