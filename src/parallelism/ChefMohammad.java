package parallelism;

public class ChefMohammad implements Runnable {

    @Override
    public void run() {
        System.out.println("Mohammad started and waiting for the shrimp to thaw ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mohammad is one cutting shrimp.");
    }

}
