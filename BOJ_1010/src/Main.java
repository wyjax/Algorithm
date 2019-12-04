import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] d = new int[31][31];

        for (int i = 1; i <= 30; i++) {
            d[1][i] = i;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = i; j <= 30; j++) {
                for (int k = j; k >= i; k--)
                    d[i][j] += d[i - 1][k - 1];
            }
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(d[n][m]);
        }
    }
}