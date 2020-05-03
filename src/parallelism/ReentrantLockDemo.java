package parallelism;

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithReentrantLock();
        Thread ali = new ShopperWithReentrantLock();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + ShopperWithReentrantLock.garlicCount + " garlic.");
        System.out.println("We should buy " + ShopperWithReentrantLock.potatoCount + " potatoes.");
    }

}
