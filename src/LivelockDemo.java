import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockDemo {

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher4("Mohammad", chopstickA, chopstickB).start();
        new Philosopher4("Ali", chopstickB, chopstickC).start();
        new Philosopher4("Majid", chopstickC, chopstickA).start();
    }

}
