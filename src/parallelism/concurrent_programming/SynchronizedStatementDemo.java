package parallelism.concurrent_programming;

public class SynchronizedStatementDemo {

    static class Shopper extends Thread {
        static int garlicCount = 0;

        public void run() {
            for (int i = 0; i < 10_000_000; i++) {
                synchronized (Shopper.class) {
                    garlicCount++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new SynchronizedMethodDemo.Shopper();
        Thread mahnaz = new SynchronizedMethodDemo.Shopper();
        mohammad.start();
        mahnaz.start();
        mohammad.join();
        mahnaz.join();
        System.out.println("We should buy " + SynchronizedMethodDemo.Shopper.garlicCount + " garlic.");
    }

}
