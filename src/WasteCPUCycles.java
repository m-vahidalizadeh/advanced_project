public class WasteCPUCycles {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        // Before creating 7 threads
        long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
        System.out.println("Process ID: " + ProcessHandle.current().pid());
        System.out.println("Thread count: " + Thread.activeCount());
        System.out.println("Memory used KB: " + usedKB);
        // Create 7 new threads
        for (int i = 0; i < 7; i++) {
            new CPUWaster().start();
        }
        // After creating 7 threads
        usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
        System.out.println("Process ID: " + ProcessHandle.current().pid());
        System.out.println("Thread count: " + Thread.activeCount());
        System.out.println("Memory used KB: " + usedKB);
    }

}
