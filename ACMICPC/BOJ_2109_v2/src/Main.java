import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];

        for (int i = 0; i < n; i++)
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        Arrays.sort(a); // 내림차순 정렬
        Queue<Integer> q = new PriorityQueue<>();
        long ans = 0;

        int j = 0;
        for (int i = 10000; i > 0; i--) { // 10000일 안에 ~ 1일 안에
            while (j < n && i == a[j].d) {
                q.add(-a[j].p);
                j++;
            }
            if (q.size() > 0)
                ans += Math.abs(q.poll());
        }
        System.out.println(ans);
    }
    /*
    최대 10000일 안에 강연을 가는 것부터 1일 안에 가는 것까지 강연을 찾아보고
    k일에 가장 비싼 돈을 받을 수 있는 강연을 선택해서 간다. 그렇게 하면 돈을
    많이 받아서 부자가 될 수 있다.
     */
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
