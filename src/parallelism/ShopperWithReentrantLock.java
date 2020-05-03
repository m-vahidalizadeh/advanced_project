package parallelism;

import java.util.concurrent.locks.ReentrantLock;

public class ShopperWithReentrantLock extends Thread {

    static int garlicCount, potatoCount = 0;
    static ReentrantLock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        System.out.println("Hold count: " + pencil.getHoldCount());
        garlicCount++;
        pencil.unlock();
    }

    private void addPotato() {
        pencil.lock();
        potatoCount++;
        addGarlic();
        pencil.unlock();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            addGarlic();
            addPotato();
        }
    }
}
