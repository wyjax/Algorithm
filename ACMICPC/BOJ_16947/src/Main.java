import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list    = new ArrayList[n];
        visited = new int[n];
        dist    = new int[n];

        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            list[n1].add(n2);
            list[n2].add(n1);
        }

        cycle(0, -1);
        solve();
    }

    static int cycle(int x, int p) {
        if (visited[x] == 1)
            return x;

        visited[x] = 1;
        for (int nx : list[x]) {
            if (nx == p) continue; // 이전 노드
            int res = cycle(nx, x);
            if (res == -2)
                return -2;
            if (res >= 0) {
                visited[x] = 2;
                if (x == res)
                    return -2;
                else
                    return res;
            }
        }
        return -1;
    }

    static void solve() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 싸이클 구성이면
            if (visited[i] == 2) {
                dist[i] = 0;
                q.add(i);
            }
            else {
                dist[i] = -1;
            }
        }
        while (q.size() > 0) {
            int x = q.remove();
            for (int nx : list[x]) {
                if (dist[nx] == -1) {
                    q.add(nx);
                    dist[nx] = dist[x] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
