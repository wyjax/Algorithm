import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static final int MAX = 1000000;
    static boolean[] visited;
    static int[] dist;
    static int[] from;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dist = new int[MAX];
        from = new int[MAX];
        visited = new boolean[MAX];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        dist[n] = 0;

        while (q.size() > 0) {
            int now = q.remove();

            if (now + 1 < MAX && !visited[now + 1]) {
                visited[now + 1] = true;
                dist[now + 1] = dist[now] + 1;
                from[now + 1] = now;
                q.add(now + 1);
            }
            if (now - 1 >= 0 && !visited[now - 1]) {
                visited[now - 1] = true;
                dist[now - 1] = dist[now] + 1;
                from[now - 1] = now;
                q.add(now - 1);
            }
            if (now * 2 < MAX && !visited[now * 2]) {
                visited[now * 2] = true;
                dist[now * 2] = dist[now] + 1;
                from[now * 2] = now;
                q.add(now * 2);
            }
        }

        System.out.println(dist[m]);
        route(m);
        System.out.println();
    }

    static void route(int a) {
        if (a != n) {
            route(from[a]);
        }
        System.out.print(a + " ");
    }
}