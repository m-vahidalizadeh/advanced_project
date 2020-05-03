package parallelism;

import java.util.stream.IntStream;

public class ShopperWithSynchronizedMethod extends Thread {

    static int garlicCount = 0;

    private static synchronized void addGarlic() {
        garlicCount++;
    }

    @Override
    public void run() {
        IntStream.range(0, 10_000_000).forEach(i -> addGarlic());
    }
}
