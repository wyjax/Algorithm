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
        int pre = 10000;

        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && a[i].d == a[j].d) {
                q.add(-a[j].p);
                j++;
            }
            while (q.size() > 0 && pre >= a[i].d) {
                ans += Math.abs(q.remove());
                pre--;
            }
            pre = a[i].d;
            i = j;
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
        return o.d - this.d;
    }
}

/*
4
50 2
10 1
20 2
30 1

 */