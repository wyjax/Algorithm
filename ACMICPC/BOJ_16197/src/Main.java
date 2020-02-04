import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int ans = -1;
    static char[][] a;
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];

        int[] w = new int[4];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);

                if (a[i][j] == 'o') {
                    w[idx++] = i;
                    w[idx++] = j;
                }
            }
        }

        dfs(w[0], w[1], w[2], w[3], 0, 0);
        System.out.println(ans);
    }

    static void dfs(int x1, int y1, int x2, int y2, int cnt, int res) {
        if (cnt > 10 || ans > 0 && cnt > ans)
            return;
        if (res == 1) {
            if (ans == -1 || ans > cnt)
                ans = cnt;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];
            int tmp = 0;

            if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m) {
                tmp++;
            }
            if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m) {
                tmp++;
            }

            // 동전이 2개가 나간 경우
            if (tmp == 2) continue;
            // 동전 1개만 나갈 경우
            if (tmp == 1) {
                dfs(nx1, ny1, nx2, ny2, cnt + 1, tmp);
                continue;
            }
            if (a[nx1][ny1] == '#') { // 벽
                nx1 = x1;
                ny1 = y1;
            }
            if (a[nx2][ny2] == '#') { // 벽
                nx2 = x2;
                ny2 = y2;
            }
            dfs(nx1, ny1, nx2, ny2, cnt + 1, tmp);
        }
    }
}