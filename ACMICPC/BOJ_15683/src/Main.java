import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static char[][] a;
    static int[] dir;
    static int n, m;
    static ArrayList<Pair> q;
    static int answer = 64;
    static int[][] cctv = {{0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};
    static int[] cctv_dir = {4, 2, 4, 4, 1};
    static int[] angle = {1, 2, 2, 3, 4};
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new char[n][m];
        q = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = st.nextToken().charAt(0);
                if (a[i][j] >= '1' && a[i][j] <= '5')
                    q.add(new Pair(i, j));
            }
        }
        dir = new int[q.size()];
        search(0);

        System.out.println(answer);
    }

    static void search(int cnt) {
        if (cnt == q.size()) {
            cal();
            return;
        }

        Pair p = q.get(cnt);

        for (int j = 0; j < cctv_dir[a[p.x][p.y] - '0' - 1]; j++) {
            dir[cnt] = j;
            search(cnt + 1);
        }
    }

    static void cal() {
        char[][] tmp = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                tmp[i][j] = a[i][j];
        }

        // cctv 개수 for문
        for (int i = 0; i < q.size(); i++) {
            Pair p = q.get(i);
            int cur = a[p.x][p.y] - '0';
            int go = dir[i];

            // 정한 방향
            for (int j = 0; j < angle[cur - 1]; j++) {
                int nx = p.x;
                int ny = p.y;

                while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (tmp[nx][ny] == '6')
                        break;
                    if (tmp[nx][ny] == '0')
                        tmp[nx][ny] = '#';

                    nx += dx[(cctv[cur - 1][j] + dir[i]) % 4];
                    ny += dy[(cctv[cur - 1][j] + dir[i]) % 4];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == '0')
                    ans++;
            }
        }
        answer = Math.min(ans, answer);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}