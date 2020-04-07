public class Main {
    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(a));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0)
                ans += diff;
        }

        return ans;
    }

    public int maxProfit2(int[] prices) {
        int max = 0, buy = 0, sell = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sell = i + 1;
            }
            else {
                if (sell != 0) {
                    max = max + prices[sell] - prices[buy];
                    sell = 0;
                }
                buy = i + 1;
            }
        }
        if (sell != 0) {
            max = max + prices[sell] - prices[buy];
        }
        return max;
    }
}