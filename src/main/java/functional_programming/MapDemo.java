package functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = (x) -> x * 2;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        List<Integer> doubledList = list.stream().map(timesTwo).collect(Collectors.toList());
        System.out.println(doubledList);
    }

}
