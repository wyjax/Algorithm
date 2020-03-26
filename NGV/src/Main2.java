import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int n, m;
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[Integer.parseInt(st.nextToken())].add(i);
        }

        int[] son = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            son[i] = bfs(i);
        }

        long answer = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            answer += son[first] - son[second];
        }
        System.out.println(answer);
    }

    static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int ans = 0;

        while (q.size() > 0) {
            int x = q.remove();

            for (int i = 0; i < list[x].size(); i++) {
                int next = list[x].get(i);
                ans++;
                q.add(next);
            }
        }
        return ans;
    }
}
