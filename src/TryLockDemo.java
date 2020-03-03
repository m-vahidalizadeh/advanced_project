public class TryLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread mohammad = new ShopperWithTryLock("Mohammad");
        Thread ali = new ShopperWithTryLock("Ali");
        long start = System.currentTimeMillis();
        mohammad.start();
        ali.start();
        mohammad.join();
        ali.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (float) (finish - start) / 1000 + " seconds.");
    }

}
