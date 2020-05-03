package parallelism;

public class BarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        // Create 10 shoppers Mohammad 0-4 and Mahnaz 0-4
        ShopperWithBarrier[] shoppers = new ShopperWithBarrier[10];
        for (int i = 0; i < shoppers.length / 2; i++) {
            shoppers[2 * i] = new ShopperWithBarrier("Mohammad-" + i);
            shoppers[2 * i + 1] = new ShopperWithBarrier("Mahnaz-" + i);
        }
        for (ShopperWithBarrier s : shoppers)
            s.start();
        for (ShopperWithBarrier s : shoppers)
            s.join();
        System.out.format("We need to buy %s bags of chips.", ShopperWithBarrier.bagsOfChips);
    }

}
