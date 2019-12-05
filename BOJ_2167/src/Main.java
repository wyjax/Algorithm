import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] a = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++)
                a[i][j] = Integer.parseInt(s[j - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] += d[i][j - 1] + a[i][j];
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);

            int ans = 0;
            for (int q = i; q <= x; q++) {
                ans += d[q][y] - d[q][j - 1];
            }
            bw.write(Integer.toString(ans) + "\n");
            bw.flush();
        }
    }
}