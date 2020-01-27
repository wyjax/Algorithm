import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] a = new int[50][50];
    static boolean[][] check = new boolean[50][50];
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) return;

            a = new int[w][h];
            check = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (check[i][j]) continue;
                    if (a[i][j] == 0) continue;

                    cnt++;
                    check[i][j] = true;
                    bfs(i, j);
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);

        while (qx.size() > 0) {
            int xx = qx.remove();
            int yy = qy.remove();

            for (int i = 0; i < dx.length; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if (check[nx][ny]) continue;
                if (a[nx][ny] == 0) continue;

                qx.add(nx);
                qy.add(ny);
                check[nx][ny] = true;
            }
        }
    }
}