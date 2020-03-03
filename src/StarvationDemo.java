import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StarvationDemo {

    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        for (int i = 0; i < 5000; i++) {
            new Philosopher3("Mohammad", chopstickA, chopstickB).start();
            new Philosopher3("Ali", chopstickA, chopstickB).start();
            new Philosopher3("Majid", chopstickA, chopstickB).start();
        }
    }

}
