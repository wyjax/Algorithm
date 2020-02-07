import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n = 8;
    static final int[] dx = {1, -1, 0, 0, -1, -1, 1, 1, 0};
    static final int[] dy = {0, 0, 1, -1, -1, 1, -1, 1, 0};
    static char[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new char[n][n];
        /*
            처음에 2차원 배열로 check 설계했지만 같은 위치를 다시 오게 되는 상황이 있어서
            3차원으로 바꿔서 해결
         */
        boolean[][][] check = new boolean[n][n][9];

        for (int i = 0; i < 8; i++) {
            String s = sc.next();
            for (int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n - 1, 0));
        check[n - 1][0][0] = true;

        while (q.size() > 0) {
            int qsize = q.size();

            for (int k = 0; k < qsize; k++) {
                Pair p = q.remove();

                if (p.x == 0 && p.y == n - 1) {
                    System.out.println(1);
                    return;
                }

                for (int i = 0; i < 9; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (a[nx][ny] == '#') continue;
                    if (nx - 1 >= 0 && a[nx - 1][ny] == '#') continue;
                    if (check[nx][ny][i]) continue;

                    check[nx][ny][i] = true;
                    q.add(new Pair(nx, ny));
                }
            }
            down();
        }
        System.out.println(0);
    }

    static void down() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                a[i][j] = a[i - 1][j];
            }
        }
        for (int j = 0; j < n; j++)
            a[0][j] = '.';
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}