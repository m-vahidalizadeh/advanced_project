package parallelism;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        ShopperWithCountdownLatch[] shoppers = new ShopperWithCountdownLatch[10];
        for (int i = 0; i < shoppers.length / 2; i++) {
            shoppers[2 * i] = new ShopperWithCountdownLatch("Mohammad-" + i);
            shoppers[2 * i + 1] = new ShopperWithCountdownLatch("Mahnaz-" + i);
        }
        for (ShopperWithCountdownLatch s : shoppers)
            s.start();
        for (ShopperWithCountdownLatch s : shoppers)
            s.join();
        System.out.format("We need to buy %s bags of chips.", ShopperWithCountdownLatch.bagsOfChips);
    }

}
