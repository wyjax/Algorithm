import java.util.Scanner;

public class Main {
    static int [][]a;
    static boolean [][]check;
    static int []dx = {1, -1, 0, 0};
    static int []dy = {0, 0, 1, -1};
    static int n, m, ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(i, j, 0, 0);
                check[i][j] = false;

                if (j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2];
                    if (i-1 >= 0) {
                        int temp2 = temp + a[i-1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i+1 < n) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i+2 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + a[i+1][j-1];
                        if (ans < temp2) ans = temp2;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            if (ans < sum)
                ans = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (check[nx][ny]) continue;
            check[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + a[nx][ny]);
            check[nx][ny] = false;
        }
    }
}
