import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // 처음 d[0]은 a[0]이랑 같다
        d[0] = a[0];
        // d[i]는 a[i]와 a[i] + d[i] 중 큰 값으로 결정
        for (int i = 1; i < n; i++) {
            d[i] = Math.max(a[i], a[i] + d[i - 1]);
        }

        // 가장 작은 값
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            ans = (ans > d[i]) ? ans : d[i];
        System.out.println(ans);
    }
}
/*
< tc >
5
10 -3 2 -5 2
10 7  9  4 6
 */