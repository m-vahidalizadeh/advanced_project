package parallelism;

import java.util.Arrays;
import java.util.Random;

public class MergeSortSolution {

    public static int[] generateRandomArray(int length) {
        System.out.format("Generating random array int[%d]...\n", length);
        Random random = new Random();
        int[] output = new int[length];
        for (int i = 0; i < length; i++)
            output[i] = random.nextInt();
        return output;
    }

    public static void main(String[] args) {
        final int NUM_EVAL_RUNS = 5;
        final int[] input = generateRandomArray(100_000_000);
        System.out.println("Evaluating sequential implementation...");
        SequentialMergeSorter sms = new SequentialMergeSorter(Arrays.copyOf(input, input.length));
        int[] sequentialResult = sms.sort();
        double sequentialTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            sms = new SequentialMergeSorter(Arrays.copyOf(input, input.length));
            long start = System.currentTimeMillis();
            sms.sort();
            sequentialTime += System.currentTimeMillis() - start;
        }
        sequentialTime /= NUM_EVAL_RUNS;

        System.out.println("Evaluating parallel implementation...");
        ParallelMergeSorter pms = new ParallelMergeSorter(Arrays.copyOf(input, input.length));
        int[] parallelResult = pms.sort();
        double parallelTime = 0;
        for (int i = 0; i < NUM_EVAL_RUNS; i++) {
            pms = new ParallelMergeSorter(Arrays.copyOf(input, input.length));
            long start = System.currentTimeMillis();
            pms.sort();
            parallelTime += System.currentTimeMillis() - start;
        }
        parallelTime /= NUM_EVAL_RUNS;

        if (!Arrays.equals(sequentialResult, parallelResult))
            throw new Error("ERROR: sequential result and parallel result do not match!");
        System.out.format("Average sequential time: %.1f ms\n", sequentialTime);
        System.out.format("Average parallel time: %.1f ms\n", parallelTime);
        System.out.format("Speedup: %.2f \n", sequentialTime / parallelTime);
        System.out.format("Efficiency: %.2f%%\n", 100 * (sequentialTime / parallelTime) / Runtime.getRuntime().availableProcessors());
    }

}
