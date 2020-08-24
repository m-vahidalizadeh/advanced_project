package concurrent_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {

    static class Shopper extends Thread {

        private int itemsToAdd = 0;

        private static int itemsOnNotepad = 0;
        private static Lock pencil = new ReentrantLock();

        public Shopper(String name) {
            this.setName(name);
        }

        public void run() {
            while (itemsOnNotepad <= 20) {
                if ((itemsToAdd > 0) && pencil.tryLock()) {
                    try {
                        itemsOnNotepad += itemsToAdd;
                        System.out.println(this.getName() + " added " + itemsToAdd + " item(s) to notepad.");
                        itemsToAdd = 0;
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        pencil.unlock();
                    }
                } else {
                    try {
                        Thread.sleep(100);
                        itemsToAdd++;
                        System.out.println(this.getName() + " found something to buy.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new Shopper("Mohammad");
        Thread mahnaz = new Shopper("Mahnaz");
        long start = System.currentTimeMillis();
        mohammad.start();
        mahnaz.start();
        mohammad.join();
        mahnaz.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (float) (finish - start) / 1000 + " seconds");
    }

}
