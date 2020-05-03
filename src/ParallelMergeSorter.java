import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSorter {

    private int[] array;

    public ParallelMergeSorter(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        int numWorkers = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(numWorkers);
        pool.invoke(new ParallelWorker(0, array.length - 1));
        return array;
    }

    private class ParallelWorker extends RecursiveAction {
        private int left, right;

        public ParallelWorker(int left, int right) {
            this.left = left;
            this.right = right;
        }

        protected void compute() {
            if (left < right) {
                int mid = (left + right) / 2;
                ParallelWorker leftWorker = new ParallelWorker(left, mid);
                ParallelWorker rightWorker = new ParallelWorker(mid + 1, right);
                invokeAll(leftWorker, rightWorker);
                merge(left, mid, right);
            }
        }

        private void merge(int left, int mid, int right) {
            int[] leftTempArray = Arrays.copyOfRange(array, left, mid + 1);
            int[] rightTempArray = Arrays.copyOfRange(array, mid + 1, right + 1);
            int leftTempIndex = 0, rightTempIndex = 0, mergeIndex = left;
            while (leftTempIndex < mid - left + 1 || rightTempIndex < right - mid) {
                if (leftTempIndex < mid - left + 1 && rightTempIndex < right - mid) {
                    if (leftTempArray[leftTempIndex] <= rightTempArray[rightTempIndex]) {
                        array[mergeIndex] = leftTempArray[leftTempIndex];
                        leftTempIndex++;
                    } else {
                        array[mergeIndex] = rightTempArray[rightTempIndex];
                        rightTempIndex++;
                    }
                } else if (leftTempIndex < mid - left + 1) {
                    array[mergeIndex] = leftTempArray[leftTempIndex];
                    leftTempIndex++;
                } else if (rightTempIndex < right - mid) {
                    array[mergeIndex] = rightTempArray[rightTempIndex];
                    rightTempIndex++;
                }
                mergeIndex++;
            }
        }
    }

}
