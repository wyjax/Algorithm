import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) + 1;
        int[][] a = new int[n][m];
        int[][][] ans = new int[n][m][k];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        ans[0][0][0] = 1;

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && ans[nx][ny][p.k] == 0) {
                    ans[nx][ny][p.k] = ans[p.x][p.y][p.k] + 1;
                    q.add(new Pair(nx, ny, p.k));
                }
                else if (p.k < k - 1 && a[nx][ny] == 1 && ans[nx][ny][p.k + 1] == 0) {
                    ans[nx][ny][p.k + 1] = ans[p.x][p.y][p.k] + 1;
                    q.add(new Pair(nx, ny, p.k + 1));
                }
            }
        }

        int answer = -1;
        for (int i = 0; i < k; i++) {
            if (ans[n - 1][m - 1][i] == 0) continue;
            if (answer == -1 || answer > ans[n - 1][m - 1][i])
                answer = ans[n - 1][m - 1][i];
        }
        System.out.println(answer);
    }
}

class Pair {
    int x, y, k;

    public Pair(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}