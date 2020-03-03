import java.util.Scanner;

public class Main {
    static int[] a, d;
    static int n, idx = 1;

    static int search(int key) {
        int left = 0;
        int right = idx;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (d[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt() - 1;
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            int ret = search(a[i]);
            d[ret] = a[i];

            if (ret == idx)
                idx++;
        }
        System.out.println(idx);
    }
}