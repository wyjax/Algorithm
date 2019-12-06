import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        for (int i = 0; i < n; i++) {
           d[i] = 1;
           for (int j = 0; j < i; j++) {
               if (a[i] < a[j] && d[i] < d[j] + 1)
                   d[i] = d[j] + 1;
           }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[i])
                ans = d[i];
        }
        System.out.println(ans);
    }
}