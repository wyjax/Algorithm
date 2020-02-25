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
            int[] b = new int[m];

            String combo = br.readLine();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                b[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(b);
            int[] ch = new int[26];

            for (int i = 0; i < n; i++)
                ch[combo.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++) {
                ch[i] *= m + 1;
            }
            for (int i = 0; i < m; i++) {
                String str = combo.substring(b[i], combo.length());
                for (int j = 0; j < str.length(); j++)
                    ch[str.charAt(j) - 'a'] -= 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : ch)
                sb.append(num + " ");
            System.out.println(sb.toString());
        }
    }
}