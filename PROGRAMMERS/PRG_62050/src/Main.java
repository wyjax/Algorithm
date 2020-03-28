import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int answer = 0;
    int n, cnt = 1;
    int[][] g;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int[] parent;
    Queue<Pair> pq;

    public int solution(int[][] land, int height) {
        n = land.length;
        g = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    bfs(land, height, i, j);
                    cnt++;
                }
            }
        }

        pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.diff - o2.diff;
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (g[i][j] == g[nx][ny]) continue;
                    int diff = Math.abs(land[i][j] - land[nx][ny]);
                    pq.add(new Pair(g[i][j], g[nx][ny], diff));
                }
            }
        }

        parent = new int[cnt];
        for (int i = 0; i < cnt; i++)
            parent[i] = i;

        while (pq.size() > 0) {
            Pair p = pq.remove();
            if (union(p.x, p.y)) {
                answer += p.diff;
            }
        }
        return answer;
    }

    public boolean union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);
        if (a_parent != b_parent) {
            parent[b_parent] = a;
            return true;
        }
        return false;
    }

    public int find(int x) {
        if (x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void bfs(int[][] a, int height, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 0));
        g[x][y] = cnt;

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (g[nx][ny] > 0) continue;
                if (Math.abs(a[p.x][p.y] - a[nx][ny]) > height) continue;

                g[nx][ny] = cnt;
                q.add(new Pair(nx, ny, 0));
            }
        }
    }
}

class Pair {
    int x;
    int y;
    int diff;

    public Pair(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}