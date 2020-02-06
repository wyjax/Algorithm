import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][][] ans = new int[n][m][2];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++)
                a[i][j] = s.charAt(j) - '0';
        }

        Queue<Pair> q = new LinkedList<>();
        ans[0][0][0] = 1;
        q.add(new Pair(0, 0, 0));

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (a[nx][ny] == 0 && ans[nx][ny][p.z] == 0) {
                    ans[nx][ny][p.z] = ans[p.x][p.y][p.z] + 1;
                    q.add(new Pair(nx, ny, p.z));
                }
                if (a[nx][ny] == 1 && p.z == 0 && ans[nx][ny][p.z + 1] == 0) {
                    ans[nx][ny][p.z + 1] = ans[p.x][p.y][p.z] + 1;
                    q.add(new Pair(nx, ny, p.z + 1));
                }
            }
        }
        if (ans[n - 1][m - 1][1] > 0 && ans[n - 1][m - 1][0] > 0)
            System.out.println(Math.min(ans[n - 1][m - 1][1], ans[n - 1][m - 1][0]));
        else if (ans[n - 1][m - 1][1] > 0)
            System.out.println(ans[n - 1][m - 1][1]);
        else if (ans[n - 1][m - 1][0] > 0)
            System.out.println(ans[n - 1][m - 1][0]);
        else
            System.out.println(-1);
    }
}

/**
 * 메모리를 적게하려면 Pair class를 작성해서 하자
 */
class Pair {
    int x, y, z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}