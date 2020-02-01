import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[MAX];
        int[] dist = new int[MAX];

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> nq = new LinkedList<>();
        dist[n] = 0;
        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()) {
            int a = q.remove();

//            for (int next : new int[]{a * 2, a - 1, a + 1}) {
//                if (next >= 0 && next < MAX) {
//                    if (!visited[next]) {
//                        visited[next] = true;
//                        if (next == a * 2) {
//                            q.add(next);
//                            dist[next] = dist[a];
//                        }
//                        else {
//                            nq.add(next);
//                            dist[next] = dist[a] + 1;
//                        }
//                    }
//                }
//            }

            if (a * 2 < MAX && a * 2 >= 0 && !visited[a * 2]) {
                visited[a * 2] = true;
                dist[a * 2] = dist[a];
                q.add(a * 2);
            }
            if (a - 1 >= 0 && a - 1 < MAX && !visited[a - 1]) {
                visited[a - 1] = true;
                dist[a - 1] = dist[a] + 1;
                nq.add(a - 1);
            }
            if (a + 1 < MAX && a + 1 >= 0 && !visited[a + 1]) {
                visited[a + 1] = true;
                dist[a + 1] = dist[a] + 1;
                nq.add(a + 1);
            }

            if (q.isEmpty()) {
                q = nq;
                nq = new LinkedList<>();
            }
        }
        System.out.println(dist[k]);
    }
}