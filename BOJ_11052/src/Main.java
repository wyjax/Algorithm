import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n + 1];
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++)
            p[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] < p[j] + dp[i - j]) {
                    dp[i] = p[j] + dp[i - j];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
