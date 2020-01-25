import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] a;
    static int[] ans;
    static boolean[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s;
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = new int[n];
        b = new boolean[n];
        ans = new int[m];

        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(a);
        search(0);
    }

    public static void search(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                b[i] = true;
                ans[cnt] = a[i];
                search(cnt + 1);
                b[i] = false;
            }
        }
    }
}