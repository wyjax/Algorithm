import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][3];
        int[][] d = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            a[i][0] = Integer.parseInt(s[0]);
            a[i][1] = Integer.parseInt(s[1]);
            a[i][2] = Integer.parseInt(s[2]);
        }

        // 처음에는 [0][i]로 시작하게 된다.
        d[0][0] = a[0][0];
        d[0][1] = a[0][1];
        d[0][2] = a[0][2];

        for (int i = 1; i < n; i++) {
            // 이전과의 집과는 다른 색으로 색칠
            d[i][0] = a[i][0] + Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] = a[i][1] + Math.min(d[i - 1][0], d[i - 1][2]);
            d[i][2] = a[i][2] + Math.min(d[i - 1][0], d[i - 1][1]);
        }

        System.out.println(Math.min(d[n - 1][0], Math.min(d[n - 1][1], d[n - 1][2])));
    }
}