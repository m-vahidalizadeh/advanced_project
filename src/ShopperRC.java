import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopperRC extends Thread {

    public static int bagsOfChips = 1;
    private static Lock pencil = new ReentrantLock();

    public ShopperRC(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        if (this.getName().contains("Mahnaz")) {
            pencil.lock();
            try {
                bagsOfChips += 3;
                System.out.println(this.getName() + " ADDED three bags of chips.");
            } finally {
                pencil.unlock();
            }
        } else {
            pencil.lock();
            try {
                bagsOfChips *= 2;
                System.out.println(this.getName() + " DOUBLED the bags of chips.");
            } finally {
                pencil.unlock();
            }
        }
    }
}
