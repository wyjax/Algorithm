public class Main {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(a));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        int answer = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] < nums[i]) {
                dp[i] = nums[i];
            }
            else
                dp[i] = dp[i - 1] + nums[i];

            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}