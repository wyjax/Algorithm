import java.util.Scanner;

public class Main {
    static int n, answer = 0;
    static int[] a;
    static int[] ans;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        ans = new int[n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += Math.abs(ans[i - 1] - ans[i]);
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                ans[cnt] = a[i];
                dfs(cnt + 1);
                check[i] = false;
            }
        }
    }
}
