import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    private static ArrayList<Integer>[] list;
    static boolean[] check;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n];
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            check[i] = true;
            search(1, i);
            check[i] = false;

            if (ans == 1)
                break;
        }
        System.out.println(ans);
    }

    public static void search(int cnt, int pre) {
        if (ans == 1) return;
        if (cnt == 5) {
            ans = 1;
            return;
        }

        for (int i = 0; i < list[pre].size(); i++) {
            if (check[list[pre].get(i)]) continue;
            check[list[pre].get(i)] = true;
            search(cnt + 1, list[pre].get(i));
            check[list[pre].get(i)] = false;
        }
    }
}