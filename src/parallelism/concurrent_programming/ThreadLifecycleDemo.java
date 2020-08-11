package parallelism.concurrent_programming;

public class ThreadLifecycleDemo {

    static class ChefMahnaz extends Thread {
        public void run() {
            System.out.println("Mahnaz started and waiting for sausage to thaw...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mahnaz is done cutting sausage.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Mohammad started and requesting Mahnaz's help.");
        Thread mahnaz = new ChefMahnaz();
        System.out.println(" Mahnaz state: " + mahnaz.getState());

        System.out.println("Mohammad tells Mahnaz to start.");
        mahnaz.start();
        System.out.println(" Mahnaz state: " + mahnaz.getState());

        System.out.println("Mohammad continues cooking soup.");
        Thread.sleep(500);
        System.out.println(" Mahnaz state: " + mahnaz.getState());

        System.out.println("Mohammad patiently waits for Mahnaz to finish and join...");
        mahnaz.join();
        System.out.println(" Mahnaz state: " + mahnaz.getState());

        System.out.println("Mohammad and Mahnaz are both done!");
    }

}
