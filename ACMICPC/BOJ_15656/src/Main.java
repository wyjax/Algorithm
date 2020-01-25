import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] a, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = new int[n];
        ans = new int[m];

        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);
        search(0, 0);
    }

    public static void search(int cnt, int sel) {
        if (cnt == m) {
            for (int n : ans)
                System.out.print(n + " ");
            System.out.println();
            return;
        }

        for (int i = sel; i < n; i++) {
            ans[cnt] = a[i];
            search(cnt + 1, i + 1);
        }
    }
}

// git commit -m "백준 15655번 N과 M(6) > 브루트포스 풀이" BOJ_15656/