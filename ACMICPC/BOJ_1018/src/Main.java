import java.util.Scanner;

public class Main {
    static int n, m;
    static int      ans = 64;
    static char[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < (n - 7); i++) {
            for (int j = 0; j < (m - 7); j++) {
                solve(i, j);
            }
        }
        System.out.println(ans);
    }

    static void solve(int x, int y) {
        int  cnt = 0, cnt2 = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (a[i][j] == 'B')
                            cnt++;
                        else if (a[i][j] == 'W')
                            cnt2++;
                    }
                    else {
                        if (a[i][j] == 'W')
                            cnt++;
                        else if (a[i][j] == 'B')
                            cnt2++;
                    }
                }
                else {
                    if (j % 2 == 0) {
                        if (a[i][j] == 'W')
                            cnt++;
                        else if (a[i][j] == 'B')
                            cnt2++;
                    }
                    else {
                        if (a[i][j] == 'B')
                            cnt++;
                        else if (a[i][j] == 'W')
                            cnt2++;
                    }
                }
            }
            if (cnt > ans && cnt2 > ans)
                return;
        }
        if (ans > cnt)
            ans = cnt;
        if (ans > cnt2)
            ans = cnt2;
    }
}