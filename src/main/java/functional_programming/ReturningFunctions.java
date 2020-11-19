package functional_programming;

import java.util.function.Function;

public class ReturningFunctions {

    protected static class MyMath {
        public static Integer timesTwo(Integer x) {
            return x * 2;
        }

        public static Integer timesThree(Integer x) {
            return x * 3;
        }

        public static Integer timesFour(Integer x) {
            return x * 4;
        }

        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }


    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            return () -> "Hello functional!";
        };
        NoArgFunction<NoArgFunction<String>> createGreeter1 = () -> () -> "Hello functional!";
        NoArgFunction<String> greeter = createGreeter1.apply();
        System.out.println(greeter.apply());
        Function<Integer, Integer> timeTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timeThree = MyMath.createMultiplier(3);
        Function<Integer, Integer> timeFour = MyMath.createMultiplier(4);
        System.out.println(timeTwo.apply(6));
        System.out.println(timeThree.apply(6));
        System.out.println(timeFour.apply(6));
    }

}
