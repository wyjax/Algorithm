import java.util.Scanner;

public class Main {
    static boolean[][] a;
    static int n, ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new boolean[n][n];
        calc(0);
        System.out.println(ans);
    }

    static void calc(int row) {
        if (row == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            a[row][i] = true;

            if (check(row, i)) {
                calc(row + 1);
            }
            a[row][i] = false;
        }
    }

    static boolean check(int row, int col) {
        // 가로
        for (int i = 0; i < row; i++) {
            if (a[i][col])
                return false;
        }
        // 좌측 대각선
        int x = row - 1;
        int y = col - 1;
        while (x >= 0 && y >= 0) {
            if (a[x][y])
                return false;
            x--;
            y--;
        }
        x = row - 1;
        y = col + 1;
        // 우측 대각선
        while (x >= 0 && y < n) {
            if (a[x][y])
                return false;
            x--;
            y++;
        }
        return true;
    }
}