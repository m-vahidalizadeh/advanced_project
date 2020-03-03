public class MutualExclusionDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithDelay();
        Thread ali = new ShopperWithDelay();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + ShopperWithDelay.garlicCount + " garlic.");
    }

}
