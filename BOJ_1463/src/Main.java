import java.util.Scanner;

public class Main {
    static int []dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        //System.out.println(solve(n));

        dp[1] = 0;

        // Bottom-up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                int tmp = dp[i / 3] + 1;
                if (dp[i] > tmp)
                    dp[i] = tmp;
            }
            if (i % 2 == 0) {
                int tmp = dp[i / 2] + 1;
                if (dp[i] > tmp)
                    dp[i] = tmp;
            }
        }
        System.out.println(dp[n]);
    }
    // Top-Down
    public static int solve(int n) {
        if (n == 1) return 0;
        if (dp[n] > 0) return dp[n];

        dp[n] = solve(n - 1) + 1;
        if (n % 2 == 0) {
            int tmp = solve(n / 2) + 1;
            if (dp[n] > tmp)
                dp[n] = tmp;
        }
        if (n % 3 == 0) {
            int tmp = solve(n / 3) + 1;
            if (dp[n] > tmp)
                dp[n] = tmp;
        }

        return dp[n];
    }
}