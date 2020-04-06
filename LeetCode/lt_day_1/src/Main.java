import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {2,2,1};
        System.out.println(new Solution().singleNumber(a));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1])
                    return nums[i];
            }
            else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                    return nums[i];
            }
        }
        return 0;
    }
}