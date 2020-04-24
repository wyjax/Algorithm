class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public void test() {
        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                int a = (i + j) / 2;
                int b = i + (j - i) / 2;
                System.out.println(a + " = " + b);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {5};
        System.out.println(new Solution().search(a, 5));
        new Solution().test();
    }
}
