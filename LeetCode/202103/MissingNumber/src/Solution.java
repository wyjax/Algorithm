import java.util.Arrays;

class Solution {
    /*
        Runtime: 1 ms
        Memory Usage: 39.4 MB
     */
    public int missingNumber2(int[] nums) {
        int[] arr = new int[nums.length + 1];

        for (int n : nums) {
            arr[n] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }

        return 0;
    }

    /*
        Runtime: 5 ms
        Memory Usage: 39.8 MB
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int ret = nums.length;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                ret = (i == nums[i]) ? i + 1 : i;
                break;
            }

            if (nums[i] != i) {
                ret = i;
                break;
            }
        }

        return ret;
    }
}
