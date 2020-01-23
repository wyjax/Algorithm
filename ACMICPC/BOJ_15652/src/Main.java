import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[m];

        brute(0, 0);
    }

    public static void brute(int idx, int cnt) {
        if (cnt == m) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < n; i++) {
            a[cnt] = i + 1;
            brute(i, cnt + 1);
        }
    }
}