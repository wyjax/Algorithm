import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }

        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        int pivot = image[sr][sc];
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= image.length || ny < 0 || ny >= image[0].length) {
                    continue;
                }
                if (visited[nx][ny] == true || image[nx][ny] != pivot) {
                    continue;
                }
                visited[nx][ny] = true;
                image[nx][ny] = newColor;
                q.add(new Pair(nx, ny));
            }
        }
git commit -m "day 11 Flood Fill" ./
        return image;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
    1 1 1
    1 1 0
    1 0 1

    2 2 2
    2 2 0
    2 0 1

 */

public class Main {
    public static void main(String[] args) {

    }
}
