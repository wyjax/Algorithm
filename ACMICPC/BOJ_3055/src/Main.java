import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Pair> me = new LinkedList<>();
    static Queue<Pair> water = new LinkedList<>();
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static char[][] a;
    static int[][] ans;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        a = new char[r][c];
        ans = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);

                if (a[i][j] == '*')
                    water.add(new Pair(i, j));
                else if (a[i][j] == 'S')
                    me.add(new Pair(i, j));
            }
        }

        while (me.size() > 0) {
            int mesize = me.size();
            waterslide();

            for (int i = 0; i < mesize; i++) {
                Pair p = me.remove();

                if (a[p.x][p.y] == 'D') {
                    System.out.println(ans[p.x][p.y]);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (ans[nx][ny] > 0) continue;
                    if (a[nx][ny] == '*' || a[nx][ny] == 'X') continue;

                    ans[nx][ny] = ans[p.x][p.y] + 1;
                    me.add(new Pair(nx, ny));
                }
            }
        }
        System.out.println("KAKTUS");
    }

    static void waterslide() {
        int watersize = water.size();

        for (int t = 0; t < watersize; t++) {
            Pair p = water.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (a[nx][ny] == 'D' || a[nx][ny] == 'X' || a[nx][ny] == '*') continue;
                a[nx][ny] = '*';
                water.add(new Pair(nx, ny));
            }
        }
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}