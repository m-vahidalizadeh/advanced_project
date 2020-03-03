public class DataRaceDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new Shopper();
        Thread ali = new Shopper();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
    }

}
