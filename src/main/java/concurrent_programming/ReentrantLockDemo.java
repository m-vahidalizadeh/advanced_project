package concurrent_programming;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    static class Shopper extends Thread {
        static int garlicCount = 0, potatoCount = 0;
        static ReentrantLock pencil = new ReentrantLock();

        private static void addGarlic() {
            pencil.lock();
            System.out.println("Hold count: " + pencil.getHoldCount());
            garlicCount++;
            pencil.unlock();
        }

        private static void addPotato() {
            pencil.lock();
            potatoCount++;
            addGarlic();
            pencil.unlock();
        }

        public void run() {
            for (int i = 0; i < 10_000; i++) {
                addGarlic();
                addPotato();
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
        System.out.println("We should buy " + Shopper.potatoCount + " potatoes.");
    }

}
