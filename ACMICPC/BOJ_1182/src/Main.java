import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a;
    static int ans = 0, n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        search(0, 0, 0);
        System.out.println(ans);
    }

    static void search(int cnt, int idx, int sum) {
        if (cnt > 0 && sum == s) {
            ans++;
        }
        for (int i = idx; i < n; i++) {
            search(cnt + 1, i + 1, sum + a[i]);
        }
    }
}
