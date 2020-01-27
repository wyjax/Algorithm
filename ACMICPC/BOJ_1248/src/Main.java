import java.util.Scanner;

public class Main {
    static int n;
    static int[][] sign;
    static int[] ans;

    static boolean check(int j) {
        int sum = 0;
        for (int i = j; i >= 0; i--) {
            sum += ans[i];
            if (sign[i][j] == 0) {
                if (sum != 0) return false;
            } else if (sign[i][j] > 0) {
                if (sum <= 0) return false;
            } else if (sign[i][j] < 0) {
                if (sum >= 0) return false;
            }
        }
        return true;
    }

    static boolean go(int cnt) {
        if (cnt == n) {
            return true;
        }
        if (sign[cnt][cnt] == 0) {
            ans[cnt] = 0;
            return check(cnt) && go(cnt + 1);
        }
        for (int i = 1; i <= 10; i++) {
            ans[cnt] = sign[cnt][cnt] * i;
            if (check(cnt) && go(cnt + 1)) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = new int[n];
        sign = new int[n][n];
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                if (x == '0') {
                    sign[i][j] = 0;
                } else if (x == '+') {
                    sign[i][j] = 1;
                } else {
                    sign[i][j] = -1;
                }
                cnt += 1;
            }
        }
        go(0);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}