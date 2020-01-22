import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[k + 1][n + 1];
        d[0][0] = 1;

        /*
            K = 1 + ... + 1
                    [ K - 1]
            N = L + ... + 0
                    [ N - L]

            D[K][N] = D[K-1][N-L]

            D[0][0] = 1
            D[1][0] = D[0][0];
         */
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    d[i][j] += d[i - 1][j - l];
                    d[i][j] %= 1000000000;
                }
            }
        }

        System.out.println(d[k][n]);
    }
}