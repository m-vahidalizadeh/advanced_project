package parallelism;

public class SynchronizedStatementDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithSynchronizedBlock();
        Thread ali = new ShopperWithSynchronizedBlock();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + ShopperWithSynchronizedBlock.garlicCount + " garlic.");
    }

}
