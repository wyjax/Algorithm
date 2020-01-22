import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};\
    /*
         2
       4 1 3
         5
         6
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] dice = new int[7];

        while (l-- > 0) {
            int k = sc.nextInt() - 1;
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;

            // 동
            if (k == 0) {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            }
            // 서
            else if (k == 1) {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            }
            // 북
            else if (k == 2) {
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
            }
            // 남
            else if (k == 3) {
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
            }

            x = nx;
            y = ny;

            if (a[x][y] == 0) {
                a[x][y] = dice[6];
            } else {
                dice[6] = a[x][y];
                a[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}