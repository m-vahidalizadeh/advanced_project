import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class CellPhone extends Thread {

    private static Semaphore charger = new Semaphore(1);

    public CellPhone(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            charger.acquire();
            System.out.println(this.getName() + " is charging ...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.getName() + " is DONE charging!");
            charger.release();
        }
    }

}
