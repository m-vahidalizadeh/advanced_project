package parallelism;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Mohammad asks Mahnaz how many vegetables are in the pantry.");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future result = executor.submit(new HowManyVegetables());
        System.out.println("Mohammad can do other things while he waits for the result...");
        System.out.println("Mahnaz responded with " + result.get());
        executor.shutdown();
    }

}
