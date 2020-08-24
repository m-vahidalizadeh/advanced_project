package concurrent_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StarvationDemo {

    static class Philosopher extends Thread {
        private Lock firstChopstick, secondChopstick;
        private static int sushiCount = 500_000;

        public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
            this.setName(name);
            this.firstChopstick = firstChopstick;
            this.secondChopstick = secondChopstick;
        }

        public void run() {
            int sushiEaten = 0;
            while (sushiCount > 0) {
                firstChopstick.lock();
                secondChopstick.lock();
                try {
                    if (sushiCount > 0)
                        System.out.println(this.getName() + " took a piece! food remaining: " + sushiCount--);
                    sushiEaten++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    secondChopstick.unlock();
                    firstChopstick.unlock();
                }
            }
            System.out.println(this.getName() + " took " + sushiEaten);
        }
    }

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        for (int i = 0; i < 5000; i++) {
            new Philosopher("Mohammad", chopstickA, chopstickB).start();
            new Philosopher("Mahnaz", chopstickA, chopstickB).start();
            new Philosopher("Ali", chopstickA, chopstickB).start();
        }
    }

}
