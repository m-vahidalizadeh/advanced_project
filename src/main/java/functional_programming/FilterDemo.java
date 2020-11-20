package functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterDemo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        List<Integer> evens = numbers.stream().filter(isEven).collect(Collectors.toList());
        List<Integer> evens2 = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evens);
        System.out.println(evens2);

        List<String> words = new ArrayList<>(Arrays.asList(new String[]{"hello", "functional", "programming", "is", "cool"}));
//        Predicate<String> isLongerThanFive = s -> s.length() > 5;
        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };
        Predicate<String> isLongerThanThree = createLengthTest.apply(3);
        Predicate<String> isLongerThanTen = createLengthTest.apply(10);
        List<String> longWords = words.stream().filter(isLongerThanTen).collect(Collectors.toList());
        System.out.println(longWords);
    }

}
