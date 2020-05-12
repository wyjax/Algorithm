
class Solution {
    /*
        time complexity : O(log n)
        space complexity : O(1)

        Runtime: 0 ms
        Memory Usage: 39.4 MB
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i + 1 < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 4};
        System.out.println(new Solution().singleNonDuplicate(a));
    }
}
