import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher("Mohammad", chopstickA, chopstickB).start();
        new Philosopher("Ali", chopstickB, chopstickC).start();
        new Philosopher("Majid", chopstickA, chopstickC).start();
    }

}
