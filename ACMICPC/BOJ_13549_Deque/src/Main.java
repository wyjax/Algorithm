import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static final int MAX = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] d = new int[MAX];
        boolean[] c = new boolean[MAX];

        Deque<Integer> q = new ArrayDeque<>();
        d[n] = 0;
        c[n] = true;
        q.add(n);

        while (q.size() > 0) {
            int now = q.removeFirst();

            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (0 <= next && next < MAX) {
                    if (!c[next]) {
                        c[next] = true;

                        if (now * 2 == next) {
                            q.addFirst(next);
                            d[next] = d[now];
                        }
                        else {
                            q.addLast(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[k]);
    }
}