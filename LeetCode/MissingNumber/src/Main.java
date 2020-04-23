import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return (expectedSum - actualSum);
    }

    public int missingNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }
}

public class Main {
    public static void main(String[] args) {
        // 0 1 3 4
        int[] a = {3, 0, 1, 4};
        int[] b = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new Solution().missingNumber2(a));
    }
}
