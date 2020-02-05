import java.util.Scanner;

public class Main {
    static int n, m;
    static char[][] a;
    static int ans = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);

                if (a[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                else if (a[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        dfs(rx, ry, bx, by, -1, 0);
        System.out.println(ans);
    }

    static void dfs(int rx, int ry, int bx, int by, int dir, int cnt) {
        if (cnt >= 11)
            return;

        for (int i = 0; i < 4; i++) {
            if (dir == i) continue;
            boolean rcheck = false;
            boolean bcheck = false;

            int nrx = rx;
            int nry = ry;
            int nbx = bx;
            int nby = by;

            while (a[nrx + dx[i]][nry + dy[i]] != '#') {
                if (a[nrx][nry] == 'O') {
                    rcheck = true;
                    break;
                }
                nrx += dx[i];
                nry += dy[i];
            }
            while (a[nbx + dx[i]][nby + dy[i]] != '#') {
                if (a[nbx][nby] == 'O') {
                    bcheck = true;
                    break;
                }
                nbx += dx[i];
                nby += dy[i];
            }
            if (a[nrx][nry] == 'O')
                rcheck = true;
            if (a[nbx][nby] == 'O')
                bcheck = true;

            if (rcheck && bcheck)
                continue;
            else if (rcheck) {
                if (cnt < 10)
                    ans = 1;
                dfs(nrx, nry, nbx, nby, i, cnt + 1);
            }
            else if (bcheck)
                continue;
            else {
                if (i < 2 && nrx == nbx && nry == nby) {
                    if (i == 0 && ry > by)
                        nby += dy[i] * -1;
                    else if (i == 0 && ry < by)
                        nry += dy[i] * -1;
                    else if (i == 1 && ry > by)
                        nry += dy[i] * -1;
                    else if (i == 1 && ry < by)
                        nby += dy[i] * -1;
                }
                else if (i >= 2 && nrx == nbx && nry == nby) {
                    if (i == 2 && rx > bx)
                        nbx += dx[i] * -1;
                    else if (i == 2 && rx < bx)
                        nrx += dx[i] * -1;
                    else if (i == 3 && rx > bx)
                        nrx += dx[i] * -1;
                    else if (i == 3 && rx < bx)
                        nbx += dx[i] * -1;
                }

                dfs(nrx, nry, nbx, nby, i, cnt + 1);
            }
        }
    }
}