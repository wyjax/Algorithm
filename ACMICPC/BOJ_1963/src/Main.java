import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 2; i <= 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 10000; j += i)
                    prime[j] = true;
            }
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] d = new int[10001];
            d[n] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(n);

            while (q.size() > 0) {
                int now = q.remove();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        int next = change(now, i, j);
                        if (next == -1) continue;
                        if (prime[next]) continue;
                        if (next != n && !prime[next] && d[next] == 0) {
                            q.add(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
            System.out.println(d[m]);
        }
    }

    static int change(int now, int idx, int num) {
        if (idx == 0 && num == 0) return -1;
        String s = Integer.toString(now);
        char[] c = s.toCharArray();
        c[idx] = (char) (num + '0');
        StringBuilder sb = new StringBuilder();
        for (char cc : c)
            sb.append(cc);
        return Integer.parseInt(sb.toString());
    }
}