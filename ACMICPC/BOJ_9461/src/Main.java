import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] d = new long[101];

        d[1] = d[2] = d[3] = 1;

        for (int i = 4; i <= 100; i++) {
            d[i] = d[i - 3] + d[i - 2];
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}