package functional_programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println(String.format("acc: %d, x: %d, result: %d", acc, x, result));
            return result;
        };
        Integer sum = intList.stream().reduce(0, getSum);
        System.out.println(sum);
    }

}
