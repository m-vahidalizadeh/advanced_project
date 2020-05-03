import java.util.concurrent.RecursiveTask;

public class RecursiveSum2 extends RecursiveTask<Long> {

    private long low, high;

    public RecursiveSum2(long low, long high) {
        this.low = low;
        this.high = high;
    }

    protected Long compute() {
        if (high - low < 100) {
            long total = 0;
            for (long i = low; i <= high; i++)
                total += i;
            return total;
        } else {
            long mid = (low + high) / 2;
            RecursiveSum2 l = new RecursiveSum2(low, mid);
            RecursiveSum2 r = new RecursiveSum2(mid + 1, high);
            l.fork();
            return r.compute() + l.join();
        }
    }

}
