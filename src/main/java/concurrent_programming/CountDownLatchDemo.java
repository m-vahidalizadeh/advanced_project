package concurrent_programming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemo {

    static class Shopper extends Thread {
        public static int bagsOfChips = 1;
        private static Lock pencil = new ReentrantLock();
        private static CountDownLatch fistBump = new CountDownLatch(5);

        public Shopper(String name) {
            this.setName(name);
        }

        public void run() {
            if (this.getName().contains("Mahnaz")) {
                pencil.lock();
                try {
                    bagsOfChips += 3;
                    System.out.println(this.getName() + " added three bas of chips.");
                } finally {
                    pencil.unlock();
                }
                fistBump.countDown();
            } else {
                try {
                    fistBump.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pencil.lock();
                try {
                    bagsOfChips *= 2;
                    System.out.println(this.getName() + " doubled the bags of chips.");
                } finally {
                    pencil.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Shopper[] shoppers = new Shopper[10];
        for (int i = 0; i < shoppers.length / 2; i++) {
            shoppers[2 * i] = new Shopper("Mohammad-" + i);
            shoppers[2 * i + 1] = new Shopper("Mahnaz-" + i);
        }
        for (Shopper s : shoppers) s.start();
        for (Shopper s : shoppers) s.join();
        System.out.println("We need to buy " + Shopper.bagsOfChips + " bags of chips.");
    }

}
