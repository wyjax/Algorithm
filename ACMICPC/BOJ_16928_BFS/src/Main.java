import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[101]; // 사다리, 뱀
        int[] ans = new int[101];

        for (int i = 0; i < 101; i++) {
            a[i] = i;
            ans[i] = -1;
        }

        for (int i = 0; i < (n + m); i++) {
            a[sc.nextInt()] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        ans[1] = 0;
        q.add(1);

        while (q.size() > 0) {
            int now = q.remove();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100) continue;

                next = a[next];
                if (ans[next] < 0) {
                    ans[next] = ans[now] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println(ans[100]);
    }
}