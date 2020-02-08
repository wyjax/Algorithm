import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        int shark_x = 0, shark_y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 9) {
                    shark_x = i;
                    shark_y = j;
                    a[i][j] = 0;
                }
            }
        }

        int ans = 0, eat = 0, shark_size = 2;

        while (true) {
            Pair p = bfs(shark_x, shark_y, shark_size);
            if (p == null) break;
            a[p.x][p.y] = 0; // 먹음
            ans += p.dist;
            eat++;
            if (eat == shark_size) {
                shark_size++;
                eat = 0;
            }
            shark_x = p.x;
            shark_y = p.y;
        }
        System.out.println(ans);
    }

    static Pair bfs(int sx, int sy, int size) {
        ArrayList<Pair> ans = new ArrayList<>();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        d[sx][sy] = 0;

        while (q.size() > 0) {
            int x = q.remove();
            int y = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (d[nx][ny] > -1) continue;
                if (a[nx][ny] > size) continue;

                q.add(nx);
                q.add(ny);
                d[nx][ny] = d[x][y] + 1;
                if (0 < a[nx][ny] && a[nx][ny] < size)
                    ans.add(new Pair(nx, ny, d[nx][ny]));
            }
        }
        if (ans.isEmpty())
            return null;
        Pair best = ans.get(0);
        for (Pair p : ans) {
            if (best.dist > p.dist)
                best = p;
            else if (best.dist == p.dist && best.x > p.x)
                best = p;
            else if (best.dist == p.dist && best.x == p.x && best.y > p.y)
                best = p;
        }
        return best;
    }
}

class Pair {
    int x, y, dist;

    public Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}