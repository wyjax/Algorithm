import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] a;
    static boolean[] check;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            a[x].add(new Edge(y, z));
            a[y].add(new Edge(x, z));
        }
        // 각 정점에서 가장 멀리있는 정점을 구한다
        bfs(1);
        // dist 값을 통해서 출발 정점을 고른다
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start])
                start = i;
        }
        // 출발정점을 기점으로 종점을 찾는다.
        bfs(start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) {
            if (ans < dist[i])
                ans = dist[i];
        }
        System.out.println(ans);
    }

    public static void bfs(int start) {
        Arrays.fill(dist, 0);
        Arrays.fill(check, false);
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);

        while (q.size() > 0) {
            int x = q.remove();

            for (int i = 0; i < a[x].size(); i++) {
                Edge e = a[x].get(i);
                if (check[e.son]) continue;

                check[e.son] = true;
                dist[e.son] = dist[x] + e.weight;
                q.add(e.son);
            }
        }
    }
}

class Edge {
    int son;
    int weight;

    public Edge(int son, int weight) {
        this.son = son;
        this.weight = weight;
    }
}