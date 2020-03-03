import java.util.concurrent.locks.Lock;

public class Philosopher2 extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500;

    public Philosopher2(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while (sushiCount > 0) {
            firstChopstick.lock();
            secondChopstick.lock();
            try {
                if (sushiCount > 0) {
                    sushiCount--;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }
                // Simulate the abandoned lock scenario
                if (sushiCount == 10)
                    System.out.println(1 / 0);
            } finally {
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }

}
