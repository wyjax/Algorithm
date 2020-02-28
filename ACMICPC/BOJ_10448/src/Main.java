import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] a;
    static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = new int[51];

        for (int i = 1; i < a.length; i++) {
            a[i] = (i * (i + 1)) / 2;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            check = 0;
            search(k, 0, 0);
            sb.append(check + "\n");
        }
        System.out.print(sb.toString());
    }

    static void search(int k, int cnt, int sum) {
        if (cnt == 3) {
            if (k == sum)
                check = 1;
            return;
        }
        if (check == 1)
            return;

        for (int i = 1; i < a.length; i++) {
            if (sum + a[i] <= k)
                search(k, cnt + 1, sum + a[i]);
        }
    }
}
