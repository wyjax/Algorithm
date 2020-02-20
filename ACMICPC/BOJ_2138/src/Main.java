import java.util.Arrays;
import java.util.Scanner;

class Pair {
    boolean first;
    int cnt;

    Pair(boolean first, int cnt) {
        this.first = first;
        this.cnt = cnt;
    }
}

public class Main {
    static void change(int[] a, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (0 <= i && i < a.length)
                a[i] = 1 - a[i];
        }
    }

    static Pair go(int[] a, int[] goal) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != goal[i]) {
                change(a, i + 1);
                ans += 1;
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (a[i] != goal[i])
                ok = false;
        }
        if (ok)
            return new Pair(true, ans);
        else
            return new Pair(false, ans);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] obj = new int[n];
        String s1 = sc.next();
        String s2 = sc.next();

        for (int i = 0; i < n; i++) {
            a[i] = s1.charAt(i) - '0';
            obj[i] = s2.charAt(i) - '0';
        }

        Pair p1 = go(Arrays.copyOf(a, a.length), obj);
        change(a, 0);
        Pair p2 = go(a, obj);

        if (p2.first)
            p2.cnt += 1;
        if (p1.first && p2.first)
            System.out.printf("%d\n", Math.min(p1.cnt, p2.cnt));
        else if (p1.first)
            System.out.printf("%d\n", p1.cnt);
        else if (p2.first)
            System.out.printf("%d\n", p2.cnt);
        else
            System.out.printf("-1\n");
    }
}