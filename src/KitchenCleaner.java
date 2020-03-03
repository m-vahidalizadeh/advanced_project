public class KitchenCleaner extends Thread {

    public void run() {
        while (true) {
            System.out.println("Mohammad cleaned the kitchen.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
