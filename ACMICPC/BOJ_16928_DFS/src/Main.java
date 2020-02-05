import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] a = new int[101];
    static int[] ans = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= 100; i++)
            a[i] = i;
        for (int i = 0; i < (n + m); i++)
            a[sc.nextInt()] = sc.nextInt();
        dfs(1, 0);
        System.out.println(ans[100]);
    }

    static void dfs(int now, int cnt) {
        if (now == 100) {
            if (ans[now] == 0 || ans[now] > cnt)
                ans[now] = cnt;
            return;
        }
        if (ans[now] == 0 || ans[now] > cnt)
            ans[now] = cnt;

        for (int i = 1; i <= 6; i++) {
            int next = now + i;
            if (next > 100) break;
            next = a[next];

            if (ans[next] == 0 || ans[next] > cnt + 1) {
                dfs(next, cnt + 1);
            }
        }
    }
}