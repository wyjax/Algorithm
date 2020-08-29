import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int len = A.length;

        for (int i = 0; i < len - 1; i++) {
            int finalPos = len - 1 - i;
            int maxIndex = findMax(A, finalPos);

            if (maxIndex == finalPos) {
                continue;
            }
            if (maxIndex != 0) {
                flip(A, maxIndex);
                result.add(maxIndex + 1);
            }
            flip(A, finalPos);
            result.add(finalPos + 1);
        }

        return result;
    }

    private int findMax(int[] A, int upper) {
        int maxVal = 0;
        int maxIdx = 0;
        for (int i = 0; i <= upper; i++) {
            if (A[i] > maxVal) {
                maxVal = A[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private void flip(int[] A, int k) {
        int left = 0;
        int right = k;
        while (left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}