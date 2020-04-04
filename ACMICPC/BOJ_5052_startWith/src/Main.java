import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = new String[n];

            for (int i = 0; i < n; i++) {
                s[i] = br.readLine();
            }
            Arrays.sort(s);
            boolean check = true;
            for (int i =1; i < n; i++) {
                if (s[i].startsWith(s[i-1]))
                    check = false;
            }
            if (check)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
