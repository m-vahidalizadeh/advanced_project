import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ShopperWithAtomicInteger extends Thread {

    static AtomicInteger garlicCount = new AtomicInteger(0);

    @Override
    public void run() {
        IntStream.range(0, 10_000_000).forEach(i -> garlicCount.incrementAndGet());
    }

}
