package concurrent_programming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MeasureSpeedupDemo {

    static class RecursiveSum extends RecursiveTask<Long> {
        private long lo, hi;

        public RecursiveSum(long lo, long hi) {
            this.lo = lo;
            this.hi = hi;
        }

        protected Long compute() {
            if (hi - lo <= 100) {
                long total = 0;
                for (long i = lo; i <= hi; i++) total += i;
                return total;
            } else {
                long mid = (hi + lo) / 2;
                RecursiveSum l = new RecursiveSum(lo, mid);
                RecursiveSum r = new RecursiveSum(mid + 1, hi);
                l.fork();
                return r.compute() + l.join();
            }
        }
    }

    private static long sequentialSum(long l, long h) {
        long total = 0;
        for (long i = l; i <= h; i++) total += i;
        return total;
    }

    public static void main(String[] args) {
        final int NUM_EVAL_RUNS = 10;
        final long SUM_VALUE = 1_000_000_000L;
        System.out.println("Evaluating sequential implementation...");
        long sequentialResult = sequentialSum(0, SUM_VALUE); // Warm up
        long sequentialTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            long start = System.currentTimeMillis();
            sequentialSum(0, SUM_VALUE);
            sequentialTime += System.currentTimeMillis() - start;
        }
        sequentialTime /= NUM_EVAL_RUNS;

        System.out.println("Evaluating parallel implementation...");
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long parallelResult = pool.invoke(new RecursiveSum(0, SUM_VALUE)); // Warm up
        pool.shutdown();
        double parallelTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            long start = System.currentTimeMillis();
            pool = ForkJoinPool.commonPool();
            pool.invoke(new RecursiveSum(0, SUM_VALUE));
            pool.shutdown();
            parallelTime += System.currentTimeMillis() - start;
        }
        parallelTime /= NUM_EVAL_RUNS;
        if (sequentialResult != parallelResult)
            throw new Error("ERROR: sequential result and parallel result do not match!");
        System.out.println("Average Sequential Time: " + sequentialTime + " ms.");
        System.out.println("Average Parallel Time: " + parallelTime + " ms.");
        System.out.println("Speedup: " + (sequentialTime / parallelTime));
        System.out.println("Efficiency: " + 100 * (sequentialTime / parallelTime) / Runtime.getRuntime().availableProcessors());
    }

}
