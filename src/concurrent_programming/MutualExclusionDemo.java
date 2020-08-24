package concurrent_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusionDemo {

    static class Shopper extends Thread {
        static int garlicCount = 0;
        static Lock pencil = new ReentrantLock();

        public void run() {
            for (int i = 0; i < 5; i++) {
                pencil.lock();
                garlicCount++;
                pencil.unlock();
                System.out.println(Thread.currentThread().getName() + " is thinking.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
