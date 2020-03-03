import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Philosopher4 extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500_000;
    private Random rps = new Random();

    public Philosopher4(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while (sushiCount > 0) {
            firstChopstick.lock();
            if (!secondChopstick.tryLock()) {
                System.out.println(this.getName() + " released their first chopstick.");
                firstChopstick.unlock();
                try {
                    Thread.sleep(rps.nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (sushiCount > 0) {
                        sushiCount--;
                        System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    secondChopstick.unlock();
                    firstChopstick.unlock();
                }
            }
        }
    }

}
