import java.util.concurrent.ForkJoinPool;

public class DivideAndConquerDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long total = pool.invoke(new RecursiveSum(0, 1_000_000_000));
        pool.shutdown();
        System.out.println("Total sum is " + total);
    }

}
