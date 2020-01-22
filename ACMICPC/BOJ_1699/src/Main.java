import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];

        /*
            d[i]는 n = i^2 + (i-1)^2 + ... + 1^2;
         */

        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (d[i] > d[i - j * j] + 1)
                    d[i] = d[i - j * j] + 1;
            }
        }
        System.out.println(d[n]);
    }
}