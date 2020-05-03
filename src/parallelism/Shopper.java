package parallelism;

public class Shopper extends Thread {

    static int garlicCount = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            garlicCount++;
        }
    }
}
