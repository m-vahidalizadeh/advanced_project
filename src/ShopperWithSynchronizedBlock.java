import java.util.stream.IntStream;

public class ShopperWithSynchronizedBlock extends Thread {

    static Integer garlicCount = 0;

    public void run() {
        IntStream.range(0, 10_000_000).forEach(i -> {
            synchronized (ShopperWithSynchronizedBlock.class) {
                garlicCount++;
            }
        });
    }

}
