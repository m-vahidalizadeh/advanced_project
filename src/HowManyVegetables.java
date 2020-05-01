import java.util.concurrent.Callable;

public class HowManyVegetables implements Callable {

    public Integer call() throws Exception {
        System.out.println("Mahnaz is counting vegetables...");
        Thread.sleep(3000);
        return 42;
    }

}
