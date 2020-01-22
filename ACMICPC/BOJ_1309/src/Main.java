import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 9901;
        int n = sc.nextInt();
        long[][] d = new long[n + 1][3];

        d[1][0] = 1; // X X
        d[1][1] = 1; // O X
        d[1][2] = 1; // X O 총 3가지의 경우가 나온다.

        for (int i = 2; i <= n; i++) {
            d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % mod;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % mod;
            d[i][2] = (d[i - 1][0] + d[i - 1][1]) % mod;
        }

        System.out.println((d[n][0] + d[n][1] + d[n][2]) % mod);
    }
}