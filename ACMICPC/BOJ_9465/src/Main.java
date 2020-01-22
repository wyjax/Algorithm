import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] a = new int[n + 1][2];
            int[][] d = new int[n + 1][2];

            for (int i = 0; i < 2; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    a[j][i] = Integer.parseInt(s[j - 1]);
                }
            }

            d[1][0] = a[1][0];
            d[1][1] = a[1][1];

            for (int i = 2; i <= n; i++) {
                d[i][0] = Math.max(d[i - 1][1], d[i - 2][1]) + a[i][0];
                d[i][1] = Math.max(d[i - 1][0], d[i - 2][0]) + a[i][1];
            }
            System.out.println(Math.max(d[n][0], d[n][1]));
        }
    }
}