import java.util.Scanner;

public class Main {
    static int[] v;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        a = new int[n];
        int[] d = new int[n];
        v = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            v[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }

        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (d[idx] < d[i])
                idx = i;
        }

        System.out.println(d[idx]);
        go(idx);
    }

    public static void go(int idx) {
        if (idx == -1)
            return;
        go(v[idx]);
        System.out.print(a[idx] +" ");
    }
}