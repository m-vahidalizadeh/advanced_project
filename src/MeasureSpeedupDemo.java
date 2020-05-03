import java.util.concurrent.ForkJoinPool;

public class MeasureSpeedupDemo {

    private static long sequentialSum(long low, long high) {
        long total = 0;
        for (long i = low; i <= high; i++)
            total += i;
        return total;
    }

    public static void main(String[] args) {
        final int NUM_EVAL_RUNS = 10;
        final long SUM_VALUE = 1_000_000_000L;

        System.out.println("Evaluating sequential implementation...");
        long sequentialResult = sequentialSum(0, SUM_VALUE);
        double sequentialTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            long start = System.currentTimeMillis();
            sequentialSum(0, SUM_VALUE);
            sequentialTime += System.currentTimeMillis() - start;
        }
        sequentialTime /= NUM_EVAL_RUNS;

        System.out.println("Evaluating parallel implementation...");
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long parallelResult = pool.invoke(new RecursiveSum2(0, SUM_VALUE));
        pool.shutdown();
        double parallelTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            long start = System.currentTimeMillis();
            pool = ForkJoinPool.commonPool();
            pool.invoke(new RecursiveSum2(0, SUM_VALUE));
            pool.shutdown();
            parallelTime += System.currentTimeMillis() - start;
        }
        parallelTime /= NUM_EVAL_RUNS;

        if (sequentialResult != parallelResult)
            throw new Error("ERROR: sequentialResult and parallelResult do not match!");
        System.out.format("Average sequential time: %.1f ms\n", sequentialTime);
        System.out.format("Average parallel time: %.1f ms\n", parallelTime);
        System.out.format("Speedup: %.2f \n", sequentialTime / parallelTime);
        System.out.format("Efficiency: %.2f%%\n", 100 * (sequentialTime / parallelTime) / Runtime.getRuntime().availableProcessors());
    }

}
