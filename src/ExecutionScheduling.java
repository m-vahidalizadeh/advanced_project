public class ExecutionScheduling {

    public static void main(String[] args) throws InterruptedException {
        VegetableChopper mohammad = new VegetableChopper("Mohammad");
        VegetableChopper ali = new VegetableChopper("Ali");
        mohammad.start();
        ali.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;
        mohammad.join();
        ali.join();
        System.out.println("Mohammad chopped " + mohammad.vegetable_count);
        System.out.println("Ali chopped " + ali.vegetable_count);
    }

}
