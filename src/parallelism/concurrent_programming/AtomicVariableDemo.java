package parallelism.concurrent_programming;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {

    static class Shopper extends Thread {
        static AtomicInteger garlicCount = new AtomicInteger(0);

        public void run() {
            for (int i = 0; i < 10_000_000; i++) garlicCount.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new Shopper();
        Thread mahnaz = new Shopper();
        mohammad.start();
        mahnaz.start();
        mohammad.join();
        mahnaz.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
    }

}
