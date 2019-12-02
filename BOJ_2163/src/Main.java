import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            d[i][1] = i - 1;
            for (int j = 2; j <= m; j++) {
                d[i][j] = d[i][j - 1] + i;
            }
        }

        System.out.println(d[n][m]);
    }
}