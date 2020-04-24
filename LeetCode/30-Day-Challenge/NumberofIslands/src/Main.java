import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0))
            return 0;

        int[] dx            = {1, -1, 0, 0};
        int[] dy            = {0, 0, 1, -1};
        int n               = grid.length;
        int m               = grid[0].length;
        int islandCount     = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue;
                if (visited[i][j]) continue;

                islandCount++;
                visited[i][j] = true;
                q = new LinkedList<>();
                q.add(new Point(i, j));

                while (q.size() > 0) {
                    Point p = q.remove();

                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];

                        if ((nx < 0) || (nx >= n) || (ny < 0) || (ny >= m)) continue;
                        if (grid[nx][ny] == '0') continue;
                        if (visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        return islandCount;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] a = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution().numIslands(a));
    }
}
