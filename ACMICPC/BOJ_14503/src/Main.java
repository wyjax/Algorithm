import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //         북  동  남 서

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maps = new int[n][m];
        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        while (true) {
            if (maps[x][y] == 0) {
                maps[x][y] = 2;
            }

            if (maps[x - 1][y] > 0 && maps[x + 1][y] > 0 && maps[x][y - 1] > 0 && maps[x][y + 1] > 0) {
                if (maps[x - dx[d]][y - dy[d]] == 1)
                    break;
                x -= dx[d];
                y -= dy[d];
            } else {
                d = (d + 3) % 4;

                if (maps[x + dx[d]][y + dy[d]] == 0) {
                    x += dx[d];
                    y += dy[d];
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 2) {
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}