package threads;

public class MainThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        FirstThread thread1 = new FirstThread();
        FirstThread thread2 = new FirstThread();
        FirstThread thread3 = new FirstThread();
        thread1.start();
        thread2.start();
        thread3.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

}
