import java.util.*;

public class Main {
    static int lower_bound(int[] a, int n, int key) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;

            if (key <= a[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int idx = 0;
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            int p = lower_bound(a, idx, a[i]);
            a[p] = a[i];

            if (idx == p) idx += 1;
        }
        System.out.println(idx);
    }
}

1 3 5