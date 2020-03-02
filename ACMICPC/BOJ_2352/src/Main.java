import java.util.Scanner;

public class Main {
    static int lower_bound(int[] d, int n, int key) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (d[mid] < key) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt() - 1;

        int idx = 1;
        d[0] = a[0];

        for (int i = 1; i < n; i++) {
            int ret = lower_bound(d, idx, a[i]);
            d[ret] = a[i];

            if (ret == idx) idx++;
        }

        System.out.println(idx);
    }
}

/*import java.util.*;

public class Main {
    static int lower_bound(int[] a, int n, int key) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (key <= a[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int p = lower_bound(a, len, num);
            a[p] = num;
            if (len == p) len += 1;
        }
        System.out.println(len);
    }
}*/


/*
import java.util.Scanner;

public class Main {
    static int lower_bound(int[] d, int n, int key) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (d[mid] < key) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt() - 1;

        int idx = 0;
        d[0] = a[0];

        for (int i = 1; i < n; i++) {
            if (d[idx] < a[i]) {
                d[++idx] = a[i];
                continue;
            }

            int ret = lower_bound(d, idx, a[i]);
            d[ret] = a[i];
        }

        System.out.println(idx + 1);
    }
}*/
