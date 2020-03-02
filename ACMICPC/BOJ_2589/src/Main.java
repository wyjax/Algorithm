import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int answer = 0;
    static int n, m;
    static char[][] a;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'L') {
                    BFS(new Pair(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static void BFS(Pair to) {
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(d[i], -1);

        Queue<Pair> q = new LinkedList<>();
        d[to.x][to.y] = 0;
        q.add(to);

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 'W') continue;
                if (d[nx][ny] != -1) continue;

                d[nx][ny] = d[p.x][p.y] + 1;
                q.add(new Pair(nx, ny));
                answer = Math.max(answer, d[nx][ny]);
            }
        }
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}