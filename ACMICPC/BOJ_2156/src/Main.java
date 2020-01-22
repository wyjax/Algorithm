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
            d[1] = a[0] + a[1];
        if (n > 2)
            d[2] = Math.max(a[0] + a[1], Math.max(a[0] + a[2], a[1] + a[2]));

        for (int i = 3; i < n; i++) {
            int c1 = d[i - 1];
            int c2 = a[i] + a[i - 1] + d[i - 3];
            int c3 = a[i] + d[i - 2];

            d[i] = Math.max(c1, Math.max(c2, c3));
        }

        System.out.println(d[n - 1]);
    }
}