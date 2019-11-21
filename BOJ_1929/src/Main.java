import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] check = new boolean[n + 1];
        int[] ans = new int[n + 1];
        check[0] = check[1] = true;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 2; i * i <= n; i++) {
            // 작은 것부터 방문한다. 방문했으면 넘어가고 방문안했으면 i * 2부터 방문해준다.
            if (check[i])
                continue;
            for (int j = i * 2; j <= n; j += i)
                check[j] = true;
        }
        for (int i = m; i <= n; i++) {
            if (!check[i])
                bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}