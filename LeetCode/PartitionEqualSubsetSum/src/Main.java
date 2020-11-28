class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums){
            for (int j = sum / 2; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];

            }
        }
        return dp[sum / 2];
    }
}