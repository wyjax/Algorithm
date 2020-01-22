import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++)
                a[i][j] = Integer.parseInt(s[j]);
        }

        d[0][0] = a[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int left = 0, right = 0;

                if (j - 1 >= 0)
                    left = d[i - 1][j - 1] + a[i][j];
                if (j <= i - 1)
                    right = d[i - 1][j] + a[i][j];

                d[i][j] = Math.max(left, right);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[n - 1][i])
                ans = d[n - 1][i];
        }
        System.out.println(ans);
    }
}