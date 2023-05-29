package advanced_java_programming;

import java.util.Arrays;
import java.util.List;

public class NumberUtilsMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        numbers.forEach(NumberUtils::evenOrOdd);
    }

}
