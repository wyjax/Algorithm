import java.util.Scanner;

public class Main {
    static int n, m;
    static char[][] a;
    static int[][] dist;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) continue;
                dist = new int[n][m];

                if (dfs(i, j, 1, a[i][j])) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    static boolean dfs(int x, int y, int cnt, int color) {
        if (check[x][y]) {
            if (cnt - dist[x][y] >= 4)
                return true;
            return false;
        }

        check[x][y] = true;
        dist[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (a[nx][ny] != color) continue;
            if (dfs(nx, ny, cnt + 1, color)) {
                return true;
            }
        }
        return false;
    }
}
