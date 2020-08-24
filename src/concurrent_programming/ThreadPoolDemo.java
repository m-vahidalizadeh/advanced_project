package concurrent_programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

    static class VegetableChopper extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " chopped a vegetable!");
        }

        public static void main(String[] args) {
            int numOfProcessors = Runtime.getRuntime().availableProcessors();
            System.out.println("Number of processors is: " + numOfProcessors);
            ExecutorService pool = Executors.newFixedThreadPool(numOfProcessors);
            IntStream.range(0, 100).forEach(i -> pool.submit(new VegetableChopper()));
            pool.shutdown();
        }
    }

}
