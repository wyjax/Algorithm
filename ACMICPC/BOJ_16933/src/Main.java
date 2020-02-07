import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][][][] ans = new int[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0, 0));
        ans[0][0][0][0] = 1;

        while (q.size() > 0) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && ans[nx][ny][p.k][1 - p.night] == 0) {
                    ans[nx][ny][p.k][1 - p.night] = ans[p.x][p.y][p.k][p.night] + 1;
                    q.add(new Pair(nx, ny, p.k, 1 - p.night));
                }
                else if (a[nx][ny] == 1 && p.k < k && p.night == 0 && ans[nx][ny][p.k + 1][1 - p.night] == 0) {
                    ans[nx][ny][p.k + 1][1 - p.night] = ans[p.x][p.y][p.k][p.night] + 1;
                    q.add(new Pair(nx, ny, p.k + 1, 1 - p.night));
                }
            }
            if (ans[p.x][p.y][p.k][1 - p.night] == 0) {
                ans[p.x][p.y][p.k][1 - p.night] = ans[p.x][p.y][p.k][p.night] + 1;
                q.add(new Pair(p.x, p.y, p.k, 1 - p.night));
            }
        }
        int answer = -1;
        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < 2; j++) {
                if (ans[n - 1][m - 1][i][j] == 0) continue;
                if (answer == -1)
                    answer = ans[n - 1][m - 1][i][j];
                else if (answer > ans[n - 1][m - 1][i][j])
                    answer = ans[n - 1][m - 1][i][j];
            }
        }
        System.out.println(answer);
    }
}

class Pair {
    int x, y, k, night;

    public Pair(int x, int y, int k, int night) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.night = night;
    }
}

/**
 * c++ 다른 방법의 풀이
 */
/*

#include <cstdio>
#include <queue>

using namespace std;

struct Node {
    int x, y, dist, crash;
};

char map[1001][1001] = { 0, };
bool visited[1001][1001][11] = { 0, };
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };
int n, m, k;

int bfs() {
    queue<Node> q;
    q.push({ 0,0,1,k });

        visited[0][0][0] = true;

    bool night = true;

    while (!q.empty()) {
        int qsize = q.size();
        night = !night;
        for (int i = 0; i < qsize; i++) {
            Node temp = q.front();
            q.pop();

            if (temp.x == n - 1 && temp.y == m - 1) {
                return temp.dist;
            }

            for (int i = 0; i < 4; i++) {
                int x1 = temp.x + dx[i];
                int y1 = temp.y + dy[i];

                if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m)
                    continue;

                if (map[x1][y1] == '0' && !visited[x1][y1][temp.crash]) {
                    visited[x1][y1][temp.crash] = true;
                    q.push({ x1,y1,temp.dist + 1, temp.crash });
                   // printf("D temp (%d,%d) -> (%d,%d) dist =%d \n", temp.x, temp.y, x1, y1, temp.dist + 1);
                }
                else if (map[x1][y1] == '1' && temp.crash > 0 && !visited[x1][y1][temp.crash - 1]) {
                    if (night) {
                        q.push({ temp.x,temp.y,temp.dist + 1,temp.crash });
                       // printf("N temp (%d,%d) -> (%d,%d) dist =%d \n", temp.x, temp.y, x1, y1, temp.dist + 1);
                    }
                    else
                    {
                        visited[x1][y1][temp.crash - 1] = true;
                        q.push({ x1,y1,temp.dist + 1,temp.crash - 1 });
                       // printf("D temp (%d,%d) -> (%d,%d) dist =%d \n", temp.x, temp.y, x1, y1, temp.dist + 1);
                    }

                }
            }
        }
    }
    return -1;
}

int main() {
    scanf("%d %d %d", &n, &m, &k);

    for (int i = 0; i < n; i++)
        scanf("%s", map[i]);

    printf("%d\n", bfs());

}

 */