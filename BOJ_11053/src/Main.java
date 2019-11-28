import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // d[i]는 d[0]~d[j]까지 검사
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[j] + 1 > d[i])
                    d[i] = d[j] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[i])
                ans = d[i];
        }

        System.out.println(ans);
    }
}