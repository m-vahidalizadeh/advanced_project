package parallelism.concurrent_programming;

public class DataRaceDemo {

    static class Shopper extends Thread {
        static int garlicCount = 0;

        public void run() {
            for (int i = 0; i < 10_000_000; i++) garlicCount++;
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
