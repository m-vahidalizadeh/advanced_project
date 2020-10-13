package concurrent_programming;

import java.util.concurrent.*;

public class FutureDemo {

    static class HowManyVegetables implements Callable {
        public Integer call() throws Exception {
            System.out.println("Mahnaz is counting vegetables...");
            Thread.sleep(3000);
            return 42;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Mohammad asks Mahnaz how many vegetables are in the pantry.");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future result = executor.submit(new HowManyVegetables());
        System.out.println("Mohammad can do other things while he waits for the result...");
        System.out.println("Mahnaz responded with " + result.get());
        executor.shutdown();
    }

}
