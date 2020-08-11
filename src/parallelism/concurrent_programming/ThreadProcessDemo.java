package parallelism.concurrent_programming;

public class ThreadProcessDemo {

    static class CPUWaster extends Thread {
        public void run() {
            while (true) ;
        }
    }

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        // Display current info about his process
        long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
        System.out.format(" Process ID: %d\n", ProcessHandle.current().pid());
        System.out.format("Thread count: %d\n", Thread.activeCount());
        System.out.format("Memory usage: %d KB\n", usedKB);

        // Start 6 new threads
        System.out.println("\nStarting 6 CPUWaster threads...\n");
        for (int i = 0; i < 6; i++) new CPUWaster().start();

        //Display current info about this process
        usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
        System.out.format(" Process ID: %d\n", ProcessHandle.current().pid());
        System.out.format("Thread count: %d\n", Thread.activeCount());
        System.out.format("Memory usage: %d KB\n", usedKB);
    }

}
