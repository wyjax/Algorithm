import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = to(st.nextToken());
            int m = to(st.nextToken());
            boolean[] check = new boolean[n];

            ArrayList<Integer>[] list = new ArrayList[n];
            for (int i = 0; i < n; i++)
                list[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
//                int first = to(st.nextToken()) - 1;
//                int second = to(st.nextToken()) - 1;
//                list[first].add(second);
//                list[second].add(first);
            }

//            int ans = 0;
//            Queue<Integer> q = new LinkedList<>();
//            check[0] = true;
//            q.add(0);
//
//            while (q.size() > 0) {
//                int x = q.remove();
//
//                for (int i = 0; i < list[x].size(); i++) {
//                    int next = list[x].get(i);
//                    if (check[next]) continue;
//                    check[next] = true;
//                    q.add(next);
//                    ans++;
//                }
//            }

//            System.out.println(ans);
            System.out.println(n - 1);
        }
    }

    public static int to(String s) {
        return Integer.parseInt(s);
    }
}
