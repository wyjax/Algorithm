import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static Pair[] check;
    static ArrayList<Pair> chck = new ArrayList<>();
    static ArrayList<Pair> home = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 2)
                    chck.add(new Pair(i, j));
                else if (input == 1)
                    home.add(new Pair(i, j));
            }
        }
        check = new Pair[m];
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == m) {
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                int h = Integer.MAX_VALUE;
                Pair h1 = home.get(i);

                for (int j = 0; j < m; j++) {
                    Pair c1 = chck.get(j);
                    h = Math.min(h, getDistance(h1.x, h1.y, c1.x, c1.y));
                }
                sum += h;
            }
            ans = Math.min(sum, ans);
            return;
        }

        for (int i = idx; i < chck.size(); i++) {
            check[cnt] = chck.get(i);
            dfs(i + 1, cnt + 1);
        }
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
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
