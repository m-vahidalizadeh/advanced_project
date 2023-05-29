package advanced_java_programming;

import java.util.Arrays;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        Double[] doubles = {2.0, 3.0, 14.7};
        Integer[] numbers = {1, 5, 7};
        List<Double> wordsList = convertArrayToList(doubles);
        List<Integer> numbersList = convertArrayToList(numbers);
        System.out.println(wordsList);
        System.out.println(numbersList);
    }

    private static <T extends Number> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }

}
