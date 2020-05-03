package parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        int numProcs = Runtime.getRuntime().availableProcessors();
        System.out.format("The number of processor are %d.", numProcs);
        ExecutorService pool = Executors.newFixedThreadPool(numProcs);
        for (int i = 0; i < 100; i++) {
            pool.submit(new VegetableChopper2());
        }
        pool.shutdown();
    }

}
