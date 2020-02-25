import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dh = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] a = new int[h][n][m];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    a[i][j][k] = Integer.parseInt(st.nextToken());

                    if (a[i][j][k] == 1)
                        q.add(new Pair(j, k, i));
                }
            }
        }

        int days = 0;

        while (q.size() > 0) {
            int qsize = q.size();

            for (int i = 0; i < qsize; i++) {
                Pair p = q.remove();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (a[p.h][nx][ny] == 1 || a[p.h][nx][ny] == -1) continue;

                    a[p.h][nx][ny] = 1;
                    q.add(new Pair(nx, ny, p.h));
                }
                for (int j = 0; j < 2; j++) {
                    int nh = p.h + dh[j];
                    if (nh < 0 || nh >= h) continue;
                    if (a[nh][p.x][p.y] == 1 || a[nh][p.x][p.y] == -1) continue;

                    a[nh][p.x][p.y] = 1;
                    q.add(new Pair(p.x, p.y, nh));
                }
            }
            days++;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(days - 1);
    }
}

class Pair {
    int x, y, h;

    public Pair(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}