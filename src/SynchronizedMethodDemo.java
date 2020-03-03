public class SynchronizedMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithSynchronizedMethod();
        Thread ali = new ShopperWithSynchronizedMethod();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + ShopperWithSynchronizedMethod.garlicCount + " garlic.");
    }

}
