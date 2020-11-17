package functional_programming;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(32, 32));
        TriFunction<Integer, Integer, Integer, Integer> triFunction = (x, y, z) -> x + y + z;
        System.out.println(triFunction.apply(1, 2, 3));
        NoArgFunction<String> noArgFunction = () -> "Hello";
        System.out.println(noArgFunction.apply());
    }

}
