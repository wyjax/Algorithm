import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] c = br.readLine().toCharArray();
        char[] ans = new char[s.length];
        int idx = 0, len = c.length;

        for (int i = 0; i < s.length; i++) {
            ans[idx++] = s[i];

            if (ans[idx - 1] == c[len - 1]) {
                if (idx - len < 0) continue;
                boolean check = true;

                for (int j = 0; j < len; j++) {
                    if (ans[idx - j - 1] != c[len - j - 1]) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    idx -= len;
            }
        }

        if (idx == 0)
            System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++)
                sb.append(ans[i]);
            System.out.println(sb.toString());
        }
    }
}