package parallelism;

public class AtomicVariableDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithAtomicInteger();
        Thread ali = new ShopperWithAtomicInteger();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + ShopperWithAtomicInteger.garlicCount + " garlic.");
    }

}
