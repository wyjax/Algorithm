import java.util.*;
class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] a = new String[n];
        int[][] water = new int[n][m];
        int[][] d = new int[n][m];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLine();
            for (int j=0; j<m; j++) {
                water[i][j] = -1;
                d[i][j] = -1;
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        int sx=0,sy=0,ex=0,ey=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i].charAt(j) == '*') {
                    q.offer(new Pair(i, j));
                    water[i][j] = 0;
                } else if (a[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (a[i].charAt(j) == 'D') {
                    ex = i;
                    ey = j;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (water[nx][ny] != -1) continue;
                if (a[nx].charAt(ny) == 'X') continue;
                if (a[nx].charAt(ny) == 'D') continue;
                water[nx][ny] = water[x][y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        q.offer(new Pair(sx, sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (d[nx][ny] != -1) continue;
                if (a[nx].charAt(ny) == 'X') continue;
                if (water[nx][ny] != -1 && d[x][y]+1 >= water[nx][ny]) continue;

                d[nx][ny] = d[x][y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        if (d[ex][ey] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(d[ex][ey]);
        }
    }
}