import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopperWithCountdownLatch extends Thread {

    public static int bagsOfChips = 1;
    private static Lock pencil = new ReentrantLock();
    private static CountDownLatch fistBump = new CountDownLatch(5);

    public ShopperWithCountdownLatch(String name) {
        this.setName(name);
    }

    public void run() {
        if (this.getName().contains("Mahnaz")) {
            pencil.lock();
            try {
                bagsOfChips += 3;
                System.out.format("%s added three bags of chips.\n", this.getName());
            } finally {
                pencil.unlock();
            }
            fistBump.countDown();
        } else {
            try {
                fistBump.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pencil.lock();
            try {
                bagsOfChips *= 2;
                System.out.format("%s doubled the bags of chips.\n", this.getName());
            } finally {
                pencil.unlock();
            }
        }
    }

}
