import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(a);
        Queue<Integer> q = new PriorityQueue<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += a[i].p;
            q.add(a[i].p);
            if (q.size() > a[i].d)
                ans -= q.remove();
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {
    int p, d;

    public Pair(int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Pair o) {
        return this.d - o.d;
    }
}