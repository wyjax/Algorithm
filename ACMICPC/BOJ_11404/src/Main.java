import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (map[a][b] == 0)
                map[a][b] = c;
            else
                map[a][b] = Math.min(c, map[a][b]);
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int from = 1; from <= n; from++) {
                if (from == mid || map[from][mid] == 0) continue;
                for (int to = 1; to <= n; to++) {
                    if (mid == to || from == to || map[mid][to] == 0) continue;
                    if (map[from][to] == 0)
                        map[from][to] = map[from][mid] + map[mid][to];
                    else
                        map[from][to] = Math.min(map[from][to], map[from][mid] + map[mid][to]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}