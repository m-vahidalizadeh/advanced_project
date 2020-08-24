package concurrent_programming;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreDemo {

    static class Cellphone extends Thread {
        private static Semaphore charger = new Semaphore(4);

        public Cellphone(String name) {
            this.setName(name);
        }

        public void run() {
            try {
                charger.acquire();
                System.out.println(this.getName() + " is charging...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(this.getName() + " is DONE charging!");
                charger.release();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) new Cellphone("Phone-" + i).start();
    }

}
