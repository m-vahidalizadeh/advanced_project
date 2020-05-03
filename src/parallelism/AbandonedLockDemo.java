package parallelism;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbandonedLockDemo {

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher2("Mohammad", chopstickA, chopstickB).start();
        new Philosopher2("Ali", chopstickB, chopstickC).start();
        new Philosopher2("Majid", chopstickA, chopstickC).start();
    }

}
