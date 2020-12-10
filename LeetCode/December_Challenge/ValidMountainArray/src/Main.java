class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] >= arr[start + 1]) {
                break;
            }
            start++;
        }
        if (start == arr.length - 1) {
            return false;
        }

        while (end > 0) {
            if (arr[end] >= arr[end - 1]) {
                break;
            }
            end--;
        }
        if (end == 0) {
            return false;
        }

        return (start == end);
    }
}

public class Main {
}

// 0 1 5 3 2 1