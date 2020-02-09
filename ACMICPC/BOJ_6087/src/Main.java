import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int sx, sy, ex, ey;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        char[][] a = new char[h][w];
        int[][] ans = new int[h][w];

        int idx = 0;
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                a[i][j] = s.charAt(j);
                ans[i][j] = -1;
                if (a[i][j] == 'C') {
                    if (idx == 0) {
                        sx = i;
                        sy = j;
                        idx++;
                    }
                    else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        ans[sx][sy] = 0;
        while (q.size() > 0) {
            Pair p = q.remove();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                while (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (a[nx][ny] == '*') break;
                    if (ans[nx][ny] == -1) {
                        ans[nx][ny] = ans[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        System.out.println(ans[ex][ey] - 1);
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}