package parallelism.concurrent_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {

    static class Philosopher extends Thread {
        private Lock firstChopstick, secondChopstick;
        private static int sushiCount = 500_000;

        public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
            this.setName(name);
            this.firstChopstick = firstChopstick;
            this.secondChopstick = secondChopstick;
        }

        public void run() {
            while (sushiCount > 0) {
                firstChopstick.lock();
                secondChopstick.lock();

                if (sushiCount > 0)
                    System.out.println(this.getName() + " took a piece! food remaining: " + sushiCount--);

                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher("Mohammad", chopstickA, chopstickB).start();
        new Philosopher("Mahnaz", chopstickB, chopstickC).start();
        new Philosopher("Ali", chopstickA, chopstickC).start();
    }

}
