import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[]a = new int[n + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                a[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int cnt = 1;
            int idx = 1;
            for (int i = 2; i <= n; i++) {
                if (a[i] <= a[idx]) {
                    idx = i;
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}