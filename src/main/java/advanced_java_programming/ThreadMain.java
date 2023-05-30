package advanced_java_programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {

    public static void main(String[] args) {
        Thread threadOne = new ThreadExample();
        Thread threadTwo = new ThreadExample();
        threadOne.setName("First thread");
        threadTwo.setName("Second thread");
        threadOne.start();
        threadTwo.start();
        Thread threadThree = new Thread(new RunnableExample());
        Thread threadFour = new Thread(() -> System.out.println("Hello world from a lambda style Runnable"));
        threadThree.setName("Third thread");
        threadFour.setName("Fourth thread");
        threadThree.start();
        threadFour.start();
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(new RunnableExample());
            executorService.submit(() -> System.out.println("Hello world from a runnable running in an ExecutorService."));
        }

    }

}
