import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] a, ans;
    static StringBuilder answer = new StringBuilder();

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
        System.out.print(answer.toString());
    }

    public static void search(int cnt, int idx) {
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (int n : ans)
                sb.append(n + " ");
            answer.append(sb.toString() + "\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            ans[cnt] = a[i];
            search(cnt + 1, i);
        }
    }
}