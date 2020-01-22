import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = 1000001;
        boolean[] check = new boolean[limit];

        // 에라토스테네스의 체
        for (int i = 2; i * i < limit; i++) {
            if (check[i]) continue;
            for (int j = i * 2; j < limit; j += i)
                check[j] = true;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            for (int i = 3; i < limit; i += 2) {
                if (check[i]) continue;
                if (!check[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
    }
}
/*
짝 + 짝 = 짝
홀 + 짝 = 홀
홀 + 홀 = 짝
 */