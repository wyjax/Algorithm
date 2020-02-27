import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < m; i++) {
            int in = sc.nextInt();
            sb.append(search(in, a.length) + "\n");
        }
        System.out.println(sb.toString());
    }

    static int search(int x, int len) {
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (x > a[mid])
                left = mid + 1;
            else if (x < a[mid])
                right = mid - 1;
            else
                return 1;
        }
        if (a[left] == x)
            return 1;
        return 0;
    }
}
