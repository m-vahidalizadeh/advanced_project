package functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {

    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (x, y) -> {
            if (y == 0) {
                System.out.println("Error: can't divide by zero.");
                return 0f;
            }
            return x / y;
        };
        BiFunction<Float, Float, Float> divide2 = (x, y) -> x / y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgNotZero =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: second arg is zero.");
                        return 0f;
                    }
                    return func.apply(x, y);
                };
        BiFunction<Float, Float, Float> divideSafe = secondArgNotZero.apply(divide2);
        System.out.println(divideSafe.apply(10f, 0f));
        System.out.println(divideSafe.apply(10f, 2f));
    }

}
