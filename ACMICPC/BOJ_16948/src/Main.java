import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] a = new int[201][201];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        a[r2][c2] = -1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r1, c1));

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (a[nx][ny] <= 0) {
                    a[nx][ny] = a[p.x][p.y] + 1;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        System.out.println(a[r2][c2]);
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}