
class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = 0;

        while (idx < nums.length && target > nums[idx]) {
            idx++;
        }
        return idx;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(new Solution().searchInsert(a, 5));
    }
}
