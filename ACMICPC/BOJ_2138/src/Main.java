import java.util.Scanner;

public class Main {
    static int[] b;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        b = new int[n];

        String s = sc.next();
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        s = sc.next();
        for (int i = 0; i < n; i++)
            b[i] = s.charAt(i);

        int ans1 = go(a);
        a[0] = 1 - a[0];
        a[1] = 1 - a[1];
        int ans2 = go(a);

        if (ans1 != -1 && ans2 != -1)
            Math.min(ans1, ans2 + 1);
        else if (ans1 != -1)
            System.out.println(ans1);
        else if (ans2 != -1)
            System.out.println(ans2 + 1);
        else
            System.out.println(-1);
    }

    public static int go(int[] a) {
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] == b[i]) continue;
            answer++;
            for (int j = i; j < i + 2; j++) {
                if (j < 0 || j >= n) continue;
                a[j] = 1 - a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return -1;
        }
        return answer;
    }
}