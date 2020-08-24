package concurrent_programming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DivideAndConquerDemo {

    static class RecursiveSum extends RecursiveTask<Long> {
        private long lo, hi;

        public RecursiveSum(long lo, long hi) {
            this.lo = lo;
            this.hi = hi;
        }

        protected Long compute() {
            if (hi - lo <= 100_000) {
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

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long total = pool.invoke(new RecursiveSum(0, 1_000_000_000));
        pool.shutdown();
        System.out.println("Total sum is " + total);
    }

}
