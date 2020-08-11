package parallelism.concurrent_programming;

public class DaemonThreadDemo {

    static class KitchenCleaner extends Thread {
        public void run() {
            while (true) {
                System.out.println("Mahnaz cleaned the kitchen.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mahnaz = new KitchenCleaner();
        mahnaz.setDaemon(true);
        mahnaz.start();

        System.out.println("Mohammad is cooking...");
        Thread.sleep(600);
        System.out.println("Mohammad is cooking...");
        Thread.sleep(600);
        System.out.println("Mohammad is cooking...");
        Thread.sleep(600);
        System.out.println("Mohammad is done!");
    }

}
