import java.util.Arrays;

public class SequentialMergeSorter {

    private int[] array;

    public SequentialMergeSorter(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        sort(0, array.length - 1);
        return array;
    }

    private void sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(left, mid);
            sort(mid + 1, right);
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
