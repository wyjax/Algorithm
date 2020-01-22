import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Main {
    public static long mod = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n + 1][10];

        // 처음에 0은 계단으로 치지 않는다.
        for (int i = 1; i <= 9; i++)
            d[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                // A가 쓰였다면 다음에 올 수 있는 수는 {A-1, A+1}
                d[i][j] = 0;
                if (j - 1 >= 0)
                    d[i][j] += d[i - 1][j - 1];
                if (j + 1 <= 9)
                    d[i][j] += d[i - 1][j + 1];
                d[i][j] %= mod;
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++)
            ans += d[n][i];
        ans %= mod;
        System.out.println(ans);
    }
}