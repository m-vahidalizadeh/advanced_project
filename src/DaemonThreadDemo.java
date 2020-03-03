public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new KitchenCleaner();
        mohammad.setDaemon(true);
        mohammad.start();
        System.out.println("Main thread is working...");
        Thread.sleep(600);
        System.out.println("Main thread is working...");
        Thread.sleep(600);
        System.out.println("Main thread is working...");
        Thread.sleep(600);
        System.out.println("Main thread is done!");
    }

}
