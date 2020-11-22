package functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplicationDemo {

    public static void main(String[] args) {
        // Partial application
        TriFunction<Integer, Integer, Integer, Integer> add =
                (x, y, z) -> x + y + z;
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                x -> (y, z) -> add.apply(x, y, z);
        BiFunction<Integer, Integer, Integer> add5 =
                addPartial.apply(5);
        System.out.println(add5.apply(6, 7));
        BiFunction<Integer, Integer, Function<Integer, Integer>> addPartial2 =
                (x, y) -> (z) -> add.apply(x, y, z);
        Function<Integer, Integer> add5And6 =
                addPartial2.apply(5, 6);
        System.out.println(add5And6.apply(7));
        // Currying
        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial3 =
                x -> y -> z -> add.apply(x, y, z);
        Function<Integer, Function<Integer, Integer>> add5_3 =
                addPartial3.apply(5);
        Function<Integer, Integer> add5And6_3 =
                add5_3.apply(6);
        System.out.println(add5And6_3.apply(7));
    }

}
