import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][] g = new int[n][m];
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        ArrayList<Integer> group_size = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0 || g[i][j] > 0) continue;
                Queue<Pair> q = new LinkedList<>();
                g[i][j] = group_size.size() + 1;
                q.add(new Pair(i, j));
                int sum = 1;

                while (q.size() > 0) {
                    Pair p = q.remove();

                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (a[nx][ny] == 1) continue;
                        if (g[nx][ny] > 0) continue;

                        g[nx][ny] = g[i][j];
                        sum += 1;
                        q.add(new Pair(nx, ny));
                    }
                }
                group_size.add(sum);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0)
                    sb.append(0);
                else if (a[i][j] == 1) {
                    HashSet<Integer> set = new HashSet<>();

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (a[nx][ny] != 0) continue;
                        set.add(g[nx][ny] - 1);
                    }
                    for (int num : set)
                        a[i][j] += group_size.get(num);
                    sb.append(a[i][j] % 10);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}