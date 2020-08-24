package concurrent_programming;

public class ExecutionSchedulingDemo {

    static class VegetableChopper extends Thread {

        public int vegetable_count = 0;
        public static boolean chopping = true;

        public VegetableChopper(String name) {
            this.setName(name);
        }

        public void run() {
            while (chopping) {
                System.out.println(this.getName() + " chopped a vegetable!");
                vegetable_count++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        VegetableChopper mohammad = new VegetableChopper("Mohammad");
        VegetableChopper mahnaz = new VegetableChopper("Mahnaz");

        mohammad.start();
        mahnaz.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;

        mohammad.join();
        mahnaz.join();
        System.out.format("Mohammad chopped %d vegetables.\n", mohammad.vegetable_count);
        System.out.format("Mahnaz chopped %d vegetables.\n", mahnaz.vegetable_count);
    }

}
