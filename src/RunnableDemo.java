public class RunnableDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread wants the help of Mohammad.");
        Thread mohammad = new Thread(new ChefMohammad());
        System.out.println("Main thread says Mohammad to start.");
        mohammad.start();
        System.out.println("Main thread continues for 500 milliseconds.");
        Thread.sleep(500);
        System.out.println("Main thread waits for Mohammad to finish and join.");
        mohammad.join();
        System.out.println("Main thread and Mohammad are both done.");
    }

}
