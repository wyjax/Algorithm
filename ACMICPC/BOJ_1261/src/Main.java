import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[m][n];
        boolean[][] check = new boolean[m][n];
        int[][] dist = new int[m][n];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < m; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = (s.charAt(j) - '0');
            }
        }

        Deque<Pair> q = new ArrayDeque<>();

        check[0][0] = true;
        dist[0][0] = 0;
        q.addFirst(new Pair(0, 0));

        while (q.size() > 0) {
            Pair p = q.removeFirst();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (check[nx][ny]) continue;

                check[nx][ny] = true;
                if (a[nx][ny] == 0) {
                    q.addFirst(new Pair(nx, ny));
                    a[nx][ny] = a[x][y];
                }
                else {
                    q.addLast(new Pair(nx, ny));
                    a[nx][ny] = a[x][y] + 1;
                }
            }
        }
        System.out.println(a[m - 1][n - 1]);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
 * Queue 풀이
 */
/*
        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> nq = new LinkedList<>();

        check[0][0] = true;
        dist[0][0] = 0;
        q.add(new Pair(0, 0));

        while (q.size() > 0) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (check[nx][ny]) continue;

                check[nx][ny] = true;
                if (a[nx][ny] == 0) {
                    q.add(new Pair(nx, ny));
                    a[nx][ny] = a[x][y];
                }
                else {
                    nq.add(new Pair(nx, ny));
                    a[nx][ny] = a[x][y] + 1;
                }
            }

            if (q.size() == 0) {
                q = nq;
                nq = new LinkedList<>();
            }
        }
 */