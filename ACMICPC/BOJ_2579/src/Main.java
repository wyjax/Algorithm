import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        d[0] = a[0];
        if (n > 1)
            d[1] = a[1] + d[0];
        if (n > 2)
            d[2] = Math.max(a[2] + a[1], a[2] + a[0]);

        // O X O O
        // X O X O
        for (int i = 3; i < n; i++) {
            d[i] = Math.max(d[i - 2] + a[i], d[i - 3] + a[i] + a[i - 1]);
        }

        System.out.println(d[n - 1]);
    }
}