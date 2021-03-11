import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp, 9999999);
        dp[0] = 0;

        for ( int coin : coins ){
            if(coin<=amount)
                dp[coin] = 1;
        }
        for (int i=1;i<=amount;i++){
            for ( int coin : coins ){
                if ( i>=coin )
                    dp[i] = Math.min ( dp[i],dp[i-coin] + dp[coin] );
            }
        }

        return dp[amount]>= 9999999 ? -1 : dp[amount];
    }
}


class Solution2 {
    int ans = Integer.MAX_VALUE;
    int minValue = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        for (int value : coins) {
            minValue = Math.min(value, minValue);
        }

        for (int i = 0; i < coins.length; i++) {
            int nextValue = amount - coins[i];

            if (nextValue >= 0) {
                go(coins, nextValue, 1);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void go(int[] coins, int amount, int count) {
        if (amount == 0) {
            ans = (count < ans) ? count : ans;

            return;
        }
        else if (amount < minValue) {
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            int nextValue = amount - coins[i];

            if (nextValue >= 0) {
                go(coins, nextValue, count + 1);
            }
        }
    }
}
