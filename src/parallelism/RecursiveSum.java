package parallelism;

import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Long> {

    private long low, high;

    public RecursiveSum(long low, long high) {
        this.low = low;
        this.high = high;
    }

    protected Long compute() {
        if (high - low <= 100_000) {
            long total = 0;
            for (long i = low; i <= high; i++) {
                total += i;
            }
            return total;
        } else {
            long mid = (low + high) / 2;
            RecursiveSum left = new RecursiveSum(low, mid);
            RecursiveSum right = new RecursiveSum(mid + 1, high);
            left.fork();
            return right.compute() + left.join();
        }
    }

}
