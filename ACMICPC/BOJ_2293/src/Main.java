import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        long[] d = new long[k + 1];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        d[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - a[i] >= 0) {
                    d[j] += d[j - a[i]];
                }
            }
        }

        System.out.println(d[k]);
    }
}