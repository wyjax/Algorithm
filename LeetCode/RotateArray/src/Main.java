
class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        new Solution().rotate(a, 3);
    }
}
