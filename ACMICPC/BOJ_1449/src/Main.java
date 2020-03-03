import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int cnt = 0;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        double cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur < a[i] + 0.5) {
                cur = a[i] - 0.5 + l;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}