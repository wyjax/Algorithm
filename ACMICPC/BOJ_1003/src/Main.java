import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] f = new int[41][2];

        f[0][0] = 1;
        f[0][1] = 0;
        f[1][0] = 0;
        f[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            f[i][0] = f[i - 1][0] + f[i - 2][0];
            f[i][1] = f[i - 1][1] + f[i - 2][1];
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(f[n][0] + " " + f[n][1]);
        }
    }
}