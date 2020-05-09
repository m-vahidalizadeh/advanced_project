package functional_programming;

import java.util.Random;
import java.util.stream.Stream;

public class LazyTests {

    public static void main(String[] args) {
        Stream.iterate(1, a -> a + 1).limit(100).forEach(a -> System.out.format("%s ", a));

        System.out.println();
        Random random = new Random();
        Stream.generate(random::nextBoolean).limit(7).forEach(a -> System.out.format("%s ", a));
    }

}
