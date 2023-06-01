package threads;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
//        FirstThread thread1 = new FirstThread();
//        FirstThread thread2 = new FirstThread();
//        FirstThread thread3 = new FirstThread();
//        thread1.start();
//        thread2.start();
//        thread3.start();

//        for (int count = 1; count <= 3; count++) {
//            FirstThread thread = new FirstThread(count);
//            thread.start();
//        }
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        thread.start();

//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Main thread is printing " + i);
//            if (i == 5) {
//                System.out.println("Main thread is pausing for 2 seconds");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        Thread taskThread=new Thread(new MyRunnable());
//        taskThread.start();
//        taskThread.interrupt();
//        Thread.sleep(3000);
//        System.out.println(taskThread.isInterrupted());

        int[] marks=new int[10];
        Thread marksThread=new Thread(new Marks(marks));
        Thread avgThread=new Thread(new Average(marks));
        marksThread.start();
        marksThread.join();
        avgThread.start();
    }

}
