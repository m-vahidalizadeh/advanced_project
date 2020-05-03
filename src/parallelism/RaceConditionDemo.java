package parallelism;

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        ShopperRC[] shoppers = new ShopperRC[10];
        for (int i = 0; i < shoppers.length / 2; i++) {
            shoppers[2 * i] = new ShopperRC("Mohammad" + i);
            shoppers[2 * i + 1] = new ShopperRC("Mahnaz" + i);
        }
        for (ShopperRC s : shoppers)
            s.start();
        for (ShopperRC s : shoppers)
            s.join();
        System.out.println("We need to buy " + ShopperRC.bagsOfChips + " bags of chips.");
    }

}
