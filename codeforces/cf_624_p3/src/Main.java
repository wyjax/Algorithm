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
            int m = Integer.parseInt(st.nextToken());
            int[] miss = new int[n];
            int[] count = new int[n];

            char[] combo = br.readLine().toCharArray();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                miss[Integer.parseInt(st.nextToken())]++;
            int[] ch = new int[26];


            int cnt = 1;
            for (int i = n - 1; i >= 0; i--) {
                count[i] = cnt;
                cnt += miss[i];
            }

            for (int i = 0; i < n; i++) {
                ch[combo[i] - 'a'] += count[i];
            }

            StringBuilder sb = new StringBuilder();
            for (int num : ch)
                sb.append(num + " ");
            System.out.println(sb.toString());
        }
    }
}