import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static int n, m;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j; k < m; k++) {
                    if (a[i][j] == a[i][k]) {
                        dfs(i, j, k);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void dfs(int y, int x1, int x2) {
        int subx = x2 - x1;
        int y2 = subx + y;

        if (y2 < n) {
            if (a[y][x1] == a[y2][x1] && a[y][x2] == a[y2][x2]) {
                int sum = (subx + 1) * (subx + 1);
                ans = Math.max(sum, ans);
            }
        }
    }
}