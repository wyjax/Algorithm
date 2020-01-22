import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = 1000001;
        boolean[] check = new boolean[limit];

        for (int i = 2; i * i < limit; i++) {
            if (check[i]) continue;
            for (int j = i * 2; j < limit; j += i)
                check[j] = true;
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int i = 3; i < limit; i += 2) {
                if (check[i]) continue;
                if (n - i < 3 || n - i < i) break;
                if (!check[n - i]) {
                    cnt++;
                }
            }
            if (cnt != 0)
                System.out.println(cnt);
        }
    }
}