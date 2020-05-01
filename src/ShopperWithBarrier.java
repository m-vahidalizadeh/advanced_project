import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopperWithBarrier extends Thread {

    public static int bagsOfChips = 1;
    private static Lock pencil = new ReentrantLock();
    private static CyclicBarrier fistBump = new CyclicBarrier(10);

    public ShopperWithBarrier(String name) {
        this.setName(name);
    }

    public void run() {
        if (this.getName().contains("Mahnaz")) {
            pencil.lock();
            try {
                bagsOfChips += 3;
                System.out.format("%s Added three bags of chips.\n", this.getName());
            } finally {
                pencil.unlock();
            }
            try {
                fistBump.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Mohammad
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
