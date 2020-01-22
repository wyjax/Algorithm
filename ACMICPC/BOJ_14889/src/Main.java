import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] a;
    static boolean[] check;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(0, -1);
        System.out.println(ans);
    }

    public static void dfs(int cnt, int v) {
        if (cnt == n / 2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check[i] == !check[j]) continue;
                    if (check[i] && check[j])
                        start += a[i][j] + a[j][i];
                    else if (!check[i] && !check[j])
                        link += a[i][j] + a[j][i];
                }
            }
            if (ans > Math.abs(start - link))
                ans = Math.abs(start - link);
            return;
        }

        for (int i = v + 1; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(cnt + 1, i);
                check[i] = false;
            }
        }
    }
}