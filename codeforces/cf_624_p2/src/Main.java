import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                b[Integer.parseInt(st.nextToken()) - 1] = 1;

            boolean out = false;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    boolean check = false;
                    if (a[i] > a[j]) {
                        for (int k = i; k < j; k++) {
                            if (b[k] == 0) {
                                check = true;
                                break;
                            }
                        }
                    }
                    if (check) {
                        out = true;
                        break;
                    }
                }
                if (out)
                    break;
            }
            if (!out)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}