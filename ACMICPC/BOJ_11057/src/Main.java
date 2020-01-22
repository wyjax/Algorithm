import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = 10007;
        long[][] d = new long[n + 1][10];

        for (int i = 0; i < 10; i++)
            d[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    d[i][j] += d[i - 1][k];
                    d[i][j] %= mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++)
            ans += d[n][i];
        System.out.println(ans % mod);
    }
}